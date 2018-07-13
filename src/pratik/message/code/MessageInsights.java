package pratik.message.code;

import java.util.Arrays;
import java.util.List;

public class MessageInsights {
	
	
	public Message Insights(String msg, String type) {
		List<String> list = Arrays.asList(msg.split(" "));
		Message message = new Message();
				
		switch(type) {
			case "messageType1" :
			message.setproduct(list.get(0));
			message.setQuant(1);
			message.setPrice(Integer.parseInt(list.get(2).replaceAll("p", " ").trim()));
			message.setOperation("");
			//System.out.println("test message type 1");
			break;
			
			case "messageType2" :
			message.setproduct(list.get(3));
			message.setQuant(Integer.parseInt(list.get(0)));
			message.setPrice(Integer.parseInt(list.get(5).replaceAll("p", " ").trim()));
			message.setOperation("");
			//System.out.println("test message type 2");
			break;
			
			case "messageType3" :
			message.setproduct(list.get(2));
			message.setQuant(0);
			message.setPrice(Integer.parseInt(list.get(1).replaceAll("p", " ").trim()));
			message.setOperation(list.get(0).toLowerCase().toString());
			//System.out.println("test message type 3");
			break;
			
			case "messageType0" :
			System.out.println("[ERROR] Invalid message format");
			message.setproduct("Invalid message format");
			break;
		}
		return message;
	}
	

}
