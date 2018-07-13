package pratik.message.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pratik.message.code.Message;
import pratik.message.code.MessageInsights;
import pratik.message.code.MessagesType;
import pratik.message.code.SalesFunction;

public class MessageProcessingTest {

	String msg1 = "apple at 10p";
	String msg2 = "20 sales of apple at 10p each";
	String msg3 = "add 20p apple";
	String msg4 = "sale of 20 apples at 10p";
	String msg5 = " ";

	@Test
	void testMessageType() {
		MessagesType tester = new MessagesType();
		assertEquals("messageType1", tester.MessageType(msg1));
		assertEquals("messageType2", tester.MessageType(msg2));
		assertEquals("messageType3", tester.MessageType(msg3));
		assertEquals("messageType0", tester.MessageType(msg4));
		assertEquals("messageType0", tester.MessageType(msg5));

	}

	@Test
	void testMessageInsights() {
		MessageInsights tester1 = new MessageInsights();
		Message message = new Message();

		message = tester1.Insights(msg1, "messageType1");
		assertEquals("apple", message.getproduct());
		assertEquals(1, message.getQuant());
		assertEquals(10, message.getPrice());
		assertEquals("", message.getOperation());

		message = tester1.Insights(msg2, "messageType2");
		assertEquals("apple", message.getproduct());
		assertEquals(20, message.getQuant());
		assertEquals(10, message.getPrice());
		assertEquals("", message.getOperation());

		message = tester1.Insights(msg3, "messageType3");
		assertEquals("apple", message.getproduct());
		assertEquals(0, message.getQuant());
		assertEquals(20, message.getPrice());
		assertEquals("add", message.getOperation());

		message = tester1.Insights(msg4, "messageType0");
		assertEquals("Invalid message format", message.getproduct());
	}

	
	@RepeatedTest(value = 50)
	void testSalesFunction() {
		SalesFunction tester2 = new SalesFunction();
		MessageInsights tester1 = new MessageInsights();
		
		Message message1 = new Message();
		message1 = tester1.Insights(msg1, "messageType1");
		Message message2 = new Message();
		message2 = tester1.Insights(msg2, "messageType2");
		Message message3 = new Message();
		message2 = tester1.Insights(msg3, "messageType3");
		tester2.messageCompute(message1);
		
		}

}
