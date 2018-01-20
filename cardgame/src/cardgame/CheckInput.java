package cardgame;

import java.io.InputStream;
import java.util.Scanner;

public class CheckInput {
	private Scanner s;
	private String[] strs;
	private Card[] cardArray;

	public CheckInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckInput(InputStream in) {
		this.s = new Scanner(in);
	}

	private boolean checkString(String str) {
		if (str.equals("\\q")) {
			cardArray = null;
			return true;
		}
		
		strs = str.split(" ");
		if (strs.length == 0 || strs.length > 11)
			return false;
		cardArray = new Card[strs.length];
		for (int i = 0; i < strs.length; i++) {
			if (!strs[i].matches(CardData.getRegex()))
				return false;
		}
		return true;
	}

	private void setCardArray() {
		if (cardArray == null)
			return;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals("小王"))
				cardArray[i] = new Card("小王", "");
			else if (strs[i].equals("大王"))
				cardArray[i] = new Card("大王", "");
			else
				cardArray[i] = new Card(strs[i].substring(2), strs[i].substring(0, 2));
		}
	}

	public Card[] nextCardArray() {
		while(s.hasNextLine()){
			if(checkString(s.nextLine()))
				break;
			System.out.println("字符串输入错误!请重新输入:");
		}
		setCardArray();
		return cardArray;
	}

	public void setS(Scanner s) {
		this.s = s;
	}

}
