package pratik.message.code;

import java.util.Arrays;
import java.util.List;

public class MessagesType {
		
	public String MessageType(String msg) {
		
		List<String> list = Arrays.asList(msg.split(" "));
		if(list.size()==7)
			return "messageType2";
		else if(list.size()==3) {
			if(msg.contains("at")) {
				return "messageType1";
				}
			else
				return "messageType3";
		}
		return "messageType0";
				
	}

}
