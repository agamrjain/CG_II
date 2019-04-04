package application;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

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
				System.out.println(qDetail.getQName() + " :purged");
				purgeQ();
				
				
			}
		} );
		
		menuItem2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println(qDetail.getQName() + " :Refreshed");
				
			}
		} );
	
		getItems().add(menuItem1);
		getItems().add(menuItem2);
	
	}
	
	private void purgeQ() {
		
		try(Connection connection = factory.newConnection();
				Channel channel = connection.createChannel()){
						channel.queuePurge(qDetail.getQName());
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
}
