package helloworld;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class HelloWorldTest {
	private static final String QUEUE = "testQueue";
	private static final String MESSAGE = "Hello World!";
	private Channel channel;

	@Before
	public void initialise() throws Exception {
		ConnectionFactory connectionFactory = initialiseConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		channel = connection.createChannel();
	}

	@Test
	public void consumes_hello_world_message_from_queue() throws Exception {
		publishMessageToQueue(MESSAGE, QUEUE);

		String result = consumeMessageFromQueue(QUEUE);

		assertThat(result, is(equalTo(MESSAGE)));
	}

	private void publishMessageToQueue(String message, String queue) throws Exception {
		channel.queueDeclare(queue, false, false, false, null);
		channel.basicPublish("", queue, null, message.getBytes());
	}

	private String consumeMessageFromQueue(String queue) throws Exception {
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queue, true, consumer);

		QueueingConsumer.Delivery delivery = consumer.nextDelivery();
		return new String(delivery.getBody());
	}

	private ConnectionFactory initialiseConnectionFactory() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("dev.rabbitmq.com");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		connectionFactory.setVirtualHost("/");
		return connectionFactory;
	}
}