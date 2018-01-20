package cardgame;

import java.util.ArrayList;

public class CardData {
	private static final String[] NUMS =
		{"3", "4", "5", "6", "7", "8", "9", "10", 
		"J", "Q", "K", "A", "2", "小王", "大王"};
	private static final String[] typesArray = 
		{"红桃", "方片", "黑桃", "梅花"};
	private static ArrayList<String> numList = new ArrayList<String>();
	private static ArrayList<Card> allCard = new ArrayList<Card>();
	private static String regex;
	
	static{
		for (int i = 0; i < NUMS.length; i++) {
			numList.add(NUMS[i]);
		}
		
		for (int i = 0; i < typesArray.length; i++) {
			for (int j = 0; j < numList.size()-2; j++) {
				allCard.add(new Card( numList.get(j),
						typesArray[i]) );
			}
		}
		allCard.add(new Card("小王", ""));
		allCard.add(new Card("大王", ""));
		
		StringBuilder sb = new StringBuilder();
		sb.append("(小王)|(大王)");
		sb.append("|(").append(typesArray[0]);
		for (int i = 1; i < typesArray.length; i++)
			sb.append("|("+typesArray[i]+")");
		sb.append(")(").append(numList.get(0));
		for (int i = 1; i < numList.size()-2; i++)
			sb.append("|("+numList.get(i)+")");
		sb.append(")");
		regex = sb.toString();
	}

	public static String[] getTypesArray() {
		return typesArray;
	}

	public static ArrayList<String> getNumList() {
		return numList;
	}
	
	public static ArrayList<Card> getAllCard() {
		return allCard;
	}

	public static String getRegex() {
		return regex;
	}

}
