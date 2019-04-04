package application;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.Queue;

public class QueueDetail {

	private String qName;
	private int totalConsumer;
	private int totalMsg;
	private int unackMsg;
	private ConnectionFactory connectionFactory;

	
	public QueueDetail(String qName, int totalConsumer, int totalMsg, int unackMsg) {
		super();
		this.qName = qName;
		this.totalConsumer = totalConsumer;
		this.totalMsg = totalMsg;
		this.unackMsg = unackMsg;
	}
	
	

	public QueueDetail(String qName) {
		super();
		this.qName = qName;
	}


	public String getQName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public int getTotalConsumer() {
		return totalConsumer;
	}

	public void setTotalConsumer(int totalConsumer) {
		this.totalConsumer = totalConsumer;
	}

	public int getTotalMsg() {
		return totalMsg;
	}

	public void setTotalMsg(int totalMsg) {
		this.totalMsg = totalMsg;
	}

	public int getUnackMsg() {
		return unackMsg;
	}

	public void setUnackMsg(int unackMsg) {
		this.unackMsg = unackMsg;
	}
	
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
	
	
	public void refreshQueueDetail() throws IOException, TimeoutException {
		try(Connection connection = connectionFactory.newConnection();
				Channel channel = connection.createChannel()){
			
			Queue.DeclareOk p = channel.queueDeclarePassive(qName);
			setTotalConsumer(p.getConsumerCount());
			setTotalMsg(p.getMessageCount());
		
		} 
		
		
	}
	
	public void refreshQueueDetail2(Channel channel) throws IOException, TimeoutException {
		try{
			Queue.DeclareOk p = channel.queueDeclarePassive(qName);
			setTotalConsumer(p.getConsumerCount());
			setTotalMsg(p.getMessageCount());
		}catch (Exception e) {
			System.err.println("Error in channel.");
		} 
		
		
	}



	@Override
	public String toString() {
		return "QueueDetail [qName=" + qName + "]";
	}
	
	
	
}
