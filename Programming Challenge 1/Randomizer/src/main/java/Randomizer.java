import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by kverma on 5/19/2017.
 */
public class Randomizer
{
	private Context context = null;
	private QueueConnectionFactory factory = null;
	private QueueConnection connection = null;
	private Queue queue = null;
	private QueueSession session = null;
	private QueueReceiver receiver = null;

	public Randomizer()
	{

	}

	public void receiveObjectMessage()
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
			receiver = session.createReceiver(queue);
			connection.start();
			Message message = receiver.receive();
			if (message instanceof ObjectMessage)
			{
				Object object = ((ObjectMessage) message).getObject();
				System.out.println(this.getClass().getName() + " has received a message : "
						+ (EventMessage) object);
			}

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

	public static void main(String[] args)
	{
		PrimeRandomizer p = new PrimeRandomizer();
		p.sendObjectMessage(String.valueOf(p.randomPrime()));
		Randomizer r = new Randomizer();
		r.receiveObjectMessage();
	}
}
