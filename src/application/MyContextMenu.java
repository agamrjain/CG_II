package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;

public class MyContextMenu extends ContextMenu {

	QueueDetail qDetail;
	private ConnectionFactory factory;

	public MyContextMenu(QueueDetail qDetail, ConnectionFactory factory) {
		super();
		this.qDetail = qDetail;
		this.factory = factory;
		MenuItem menuItem1 = new MenuItem("Purge");
		MenuItem menuItem2 = new MenuItem("Write Msg");

		menuItem1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// System.out.println(qDetail.getQName() + " :purged");
				purgeQ();

			}
		});

		menuItem2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// System.out.println(qDetail.getQName() + " :Refreshed");
				String folder = getFolderPath();
				writeAllToFile(folder);
			}
		});

		getItems().add(menuItem1);
		getItems().add(menuItem2);

	}

	protected String getFolderPath() {
		String folderName = null;
		try {
			folderName = "";
			DirectoryChooser directoryChooser = new DirectoryChooser();
			File selectedDirectory = directoryChooser.showDialog(getOwnerWindow());
			folderName = selectedDirectory.getAbsolutePath();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Can't get folder path");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
		return folderName;
	}

	private void purgeQ() {

		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.queuePurge(qDetail.getQName());
		} catch (IOException | TimeoutException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Connection Error.");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}

	}

	public void writeAllToFile(String folderPath) {
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				String messageBody = new String(delivery.getBody(), "UTF-8");
				BasicProperties basicProp = delivery.getProperties();
				Map<String, Object> h = basicProp.getHeaders();
				StringBuilder fileNameBuilder = new StringBuilder();
				h.forEach((k, v) -> {
					if (!k.contains("time"))
					fileNameBuilder.append(v).append("_");
					
				});
				String fileName = fileNameBuilder.toString();
				fileName = fileName.replaceAll(":", "-");
				fileName = fileName.replaceAll(" ", "-");
				fileName = fileName.replaceAll(".", "-");
				String completeFilePath = folderPath + "\\" + fileNameBuilder.toString() + ".xml";
 				try {
					File file = new File(completeFilePath);
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(messageBody);
					fileWriter.flush();
					fileWriter.close();
				} catch (Exception e) {

				}
			};
			boolean autoAck = false;
			String TASK_QUEUE_NAME = qDetail.getQName();
			channel.basicConsume(TASK_QUEUE_NAME, autoAck, deliverCallback, consumerTag -> {});
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Registering listener");
			alert.setHeaderText(TASK_QUEUE_NAME +" listener registering");
			alert.setContentText("Msgs will be written in:[" + folderPath+"]");
			alert.showAndWait();
			Thread.sleep(2000);
		} catch (IOException | InterruptedException | TimeoutException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Connection Error.");
			alert.setContentText(e.toString());
			alert.showAndWait();
		}
	}

}
