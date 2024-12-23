import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.ibm.mq.jms.MQQueue;
import com.ibm.mq.jms.MQQueueConnection;
import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.mq.jms.MQQueueReceiver;
import com.ibm.mq.jms.MQQueueSender;
import com.ibm.mq.jms.MQQueueSession;

public class MqStub 
{
	public static void main(String[] args) 
	{
		try 
		{
			MQQueueConnection mqConn;
			MQQueueConnectionFactory mqCF;
			final MQQueueSession mqQSession;
			MQQueue mqIn, mqOut;
			MQQueueReceiver mqReceiver;
			MQQueueSender mqSender;
			
			mqCF = new MQQueueConnectionFactory();
			mqCF.setHostName("localhost");
			mqCF.setPort(1410);
			mqCF.setQueueManager("MQTester");
			mqCF.setChannel("SYSTEM.DEF.SVRCONN");
			
			mqConn = (MQQueueConnection) mqCF.createConnection();
			mqQSession = (MQQueueSession) mqConn.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
			
			mqIn = (MQQueue) mqQSession.createQueue("QUEUE1");
			mqOut = (MQQueue) mqQSession.createQueue("QUEUE2");
			
			mqReceiver = (MQQueueReceiver) mqQSession.createReceiver(mqIn);
			mqSender = (MQQueueSender) mqQSession.createSender(mqOut);
			
			javax.jms.MessageListener Listener = new javax.jms.MessageListener() 
			{
				@Override
				public void onMessage(Message msg) 
				{
					System.out.println("Got message");
					if(msg instanceof TextMessage) 
					{
						try 
						{
							TextMessage tMsg = (TextMessage) msg;
							String msgText = tMsg.getText();
							System.out.println(msgText);
							
							TextMessage newMsg = mqQSession.createTextMessage(msgText);
	                        mqSender.send(newMsg);
	                        mqQSession.commit();
	                        System.out.println("Сообщение отправлено в QUEUE2: " + msgText);
						}
						catch (JMSException e) 
						{
							e.printStackTrace();
						}
					}
				}
			};
			
			mqReceiver.setMessageListener(Listener);
			mqConn.start();
			System.out.println("Stub Started.");
			
		} 
		catch (JMSException JMSexception) 
		{
			JMSexception.printStackTrace();
		}
		try 
		{
			Thread.sleep(60000);
		} 
		catch (InterruptedException exception) 
		{
			exception.printStackTrace();
		}
	}
}

