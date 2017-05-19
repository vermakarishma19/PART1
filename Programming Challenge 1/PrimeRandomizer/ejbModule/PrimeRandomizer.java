import java.net.ConnectException;
import java.util.Queue;
import java.util.Random;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.management.Query;
import javax.naming.Context;
import org.apache.activemq.*;
public class PrimeRandomizer {

	public void randomPrime() {

		int[] primesList = { 2, 3, 5, 7, 11, 13, 17, 19 }; // list of known
															// primes
		int num = 0;
		int i = 0;
		int counter = 1;
		Random rand = new Random(); // generate a random number

		while (i != counter) {

			num = rand.nextInt(1000) + 1;
			if (num % primesList[i] == 0) // check if num is evenly divisible by
				i++;
			else { // if it is prime exit loop
				i = 0;
				counter = 0;
			}
		}
		sendPrimeNumber(num);
	}

	public void sendPrimeNumber(int num)
	{
		 try {
             // Create a ConnectionFactory
             ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");

             // Create a Connection
             Connection connection = connectionFactory.createConnection();
             connection.start();

             // Create a Session
             Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

             // Create the destination (Topic or Queue)
             Destination destination = session.createQueue("TEST.FOO");

             // Create a MessageProducer from the Session to the Topic or Queue
             MessageProducer producer = session.createProducer(destination);
             producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

             // Create a messages
             String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
             TextMessage message = session.createTextMessage(String.valueOf(num));
             // Tell the producer to send the message
             System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
             producer.send(message);

             // Clean up
             session.close();
             connection.close();
         }
         catch (Exception e) {
             System.out.println("Caught: " + e);
             e.printStackTrace();
         }
	}

}
