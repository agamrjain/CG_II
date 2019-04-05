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
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;

public class MyContextMenu extends ContextMenu{

	QueueDetail qDetail;
	private ConnectionFactory factory;
	
	public MyContextMenu(QueueDetail qDetail, ConnectionFactory factory ) {
		super();
		this.qDetail = qDetail;
		this.factory = factory;
		 MenuItem menuItem1 = new MenuItem("Purge");
	     MenuItem menuItem2 = new MenuItem("Write Msg"); 
	     
	     
		menuItem1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//System.out.println(qDetail.getQName() + " :purged");
				purgeQ();
				
				
			}
		} );
		
		menuItem2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//System.out.println(qDetail.getQName() + " :Refreshed");
				String folder = getFolderPath();
				writeAllToFile(folder);
			}
		} );
	
		getItems().add(menuItem1);
		getItems().add(menuItem2);
	
	}
	
	protected String getFolderPath() {
		String folderName=null;
		try {
			folderName = "";
			DirectoryChooser directoryChooser = new DirectoryChooser();
			File selectedDirectory = directoryChooser.showDialog(getOwnerWindow());
			folderName = selectedDirectory.getAbsolutePath();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return folderName;
	}

	private void purgeQ() {
		
		try(Connection connection = factory.newConnection();
				Channel channel = connection.createChannel()){
						channel.queuePurge(qDetail.getQName());
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void writeAllToFile(String folder) {
		try(Connection connection = factory.newConnection();
		Channel channel = connection.createChannel()){
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				  String messageBody = new String(delivery.getBody(), "UTF-8");
				  BasicProperties a = delivery.getProperties();
				  Map<String, Object> h = a.getHeaders();
				  StringBuilder fileNameBuilder = new StringBuilder();
				  h.forEach((k,v)-> fileNameBuilder.append(v).append("_") );
				  String fileName = folder+"\\"+fileNameBuilder.toString()+".xml";
				  try{
					  FileWriter fileWriter =  new FileWriter(fileName);
					  fileWriter.write(messageBody);
					  fileWriter.close();
				  }catch (Exception e) {
					e.printStackTrace();
				}
				  
				  
				  
				};
				boolean autoAck = false;
				String TASK_QUEUE_NAME = qDetail.getQName();
				channel.basicConsume(TASK_QUEUE_NAME , autoAck, deliverCallback, consumerTag -> { });
				Thread.sleep(1000);
		} catch (IOException | InterruptedException | TimeoutException e) {
			e.printStackTrace();
		} 
}
	
	
	
	
	
}
