package pratik.message.code;

import java.util.HashMap;

import java.util.Map;

public class SalesFunction {

	Map<String, Integer> productQtyMapping = new HashMap<String, Integer>();
	Map<String, Integer> productPriceMapping = new HashMap<String, Integer>();
	Map<String, Integer> adjustments = new HashMap<String, Integer>();
	
	public void messageCompute(Message message) {
		//Filtering, storing and processing of messages of type1 and type2
		if (message.getOperation().equals("")) {
			if (!productQtyMapping.containsKey(message.getproduct())) {
				productQtyMapping.put(message.getproduct(), message.getQuant());
				productPriceMapping.put(message.getproduct(),message.getPrice() * productQtyMapping.get(message.getproduct()));
			} else {
				int finalQty = message.getQuant() + productQtyMapping.get(message.getproduct());
				int totalPrice = (message.getPrice() * message.getQuant())+ productPriceMapping.get(message.getproduct());
				productQtyMapping.put(message.getproduct(), finalQty);
				productPriceMapping.put(message.getproduct(), totalPrice);
			}
			//Filtering ,storing and processing messages of type3
		} else {
			if (!message.getOperation().equals("")) {
				String opertation = message.getOperation().toString();

				int presentValue = productPriceMapping.get(message.getproduct());
				int adjustedValue = 0;
				adjustments.put(message.getproduct(), (message.getPrice() * productQtyMapping.get(message.getproduct())));

				switch (opertation) {

				case "add":
					adjustedValue = presentValue + (message.getPrice() * productQtyMapping.get(message.getproduct()));
					productPriceMapping.put(message.getproduct(), adjustedValue);
					break;

				case "subtract":
					adjustedValue = presentValue - (message.getPrice() * productQtyMapping.get(message.getproduct()));
					productPriceMapping.put(message.getproduct(), adjustedValue);
					break;

				case "multiply":
					adjustedValue = presentValue * (message.getPrice() * productQtyMapping.get(message.getproduct()));
					productPriceMapping.put(message.getproduct(), adjustedValue);
					break;
				}
			}
		}

		
	}

}
