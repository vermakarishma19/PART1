import java.util.Properties;
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by kverma on 5/19/2017.
 */
public class PrimeRandomizer
{

	private Context context = null;
	private QueueConnectionFactory factory = null;
	private QueueConnection connection = null;
	private Queue queue = null;
	private QueueSession session = null;
	private QueueSender sender = null;

	public PrimeRandomizer()
	{

	}

	public void sendObjectMessage(String msg)
	{
		Properties initialProperties = new Properties();
		initialProperties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
				"org.exolab.jms.jndi.InitialContextFactory");
		initialProperties.put(InitialContext.PROVIDER_URL, "tcp://localhost:8080");
		try
		{
			context = new InitialContext(initialProperties);
			factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
			queue = (Queue) context.lookup("queue1");
			connection = factory.createQueueConnection();
			session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			sender = session.createSender(queue);
			EventMessage eventMessage = new EventMessage(1, msg);
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(eventMessage);
			connection.start();
			sender.send(objectMessage);
			System.out.println(this.getClass().getName() + " has sent a message : " + eventMessage);

		}
		catch (NamingException e)
		{

			e.printStackTrace();
		}
		catch (JMSException e)
		{

			e.printStackTrace();
		}
		if (context != null)
		{
			try
			{
				context.close();
			}
			catch (NamingException ex)
			{
				ex.printStackTrace();
			}
		}

		if (connection != null)
		{
			try
			{
				connection.close();
			}
			catch (JMSException ex)
			{
				ex.printStackTrace();
			}
		}

	}

	public int randomPrime()
	{

		int[] primesList =
		{ 2, 3, 5, 7, 11, 13, 17, 19 }; // list of known primes
		int num = 0;
		int i = 0;
		int counter = 1;
		Random rand = new Random(); // generate a random number

		while (i != counter)
		{
			num = rand.nextInt(1000) + 1;

			if (num % primesList[i] == 0) // check if num is evenly divisible by
											// a prime from the list
				i++;

			else
			{ // if it is prime exit loop
				i = 0;
				counter = 0;
			}
		}
		return num; // print the number
	}

}
