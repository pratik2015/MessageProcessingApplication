package pratik.message.code;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class MessageProcessing {

	public static void main(String[] args) {

		Scanner scanIn = new Scanner((System.in));
		ArrayList<String> notification = new ArrayList<String>();
		
		SalesFunction sf = new SalesFunction();
		
		int count = 0;
		String type ="";
		
		while (count <= 50) {
			String msg = scanIn.nextLine();
			notification.add(msg);
			
			//Classifying notification to message type.
			MessagesType msgType = new MessagesType();
			type = msgType.MessageType(msg);
			if(type.equals("messageType0")) {
			System.out.println("Invalid message notification format");
			}	
			
			//Formatting notification to get message details
			MessageInsights msgInsights = new MessageInsights();
			Message msgDetails = new Message();
			msgDetails = msgInsights.Insights(msg,type);
			
			//Sending message details for computation.
			count++;
			sf.messageCompute(msgDetails);
			
			Map<String, Integer> values = sf.productPriceMapping;
			Map<String, Integer> units = sf.productQtyMapping;
			Map<String, Integer> adj = sf.adjustments;
			
			if(count %10 == 0) {
				System.out.println("");
				System.out.println("[INFO] *******Sales Report generated after every 10th sale********");
					for (Map.Entry<String, Integer> entry : values.entrySet()) {
					System.out.println("Product : " + entry.getKey() + "\t\t "+"Units : "+units.get(entry.getKey())+"\t\t"+"Total Value : " + entry.getValue()+"p");
				}
			}
			
			// Stop Reading new notifications after 50th message.
			if(count == 50) {
				System.out.println("");
				System.out.println("[INFO] Pausing......Application stopped accepting input values");
				System.out.println("");
				System.out.println("[INFO] *******Logging Adjustmnets made to each sale type*******");
				for (Map.Entry<String, Integer> entry : adj.entrySet()) {
					System.out.println("Product : " + entry.getKey() + "\t\t"+"Total Adjustment : " + entry.getValue()+"p");
				}
				
			}
			
		}
		scanIn.close();
		
		
		

	}

}
