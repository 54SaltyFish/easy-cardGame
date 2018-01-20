package cardgame.old;
/**
import java.io.InputStream;
import java.util.Scanner;

public class CheckIn {
	private Scanner s;
	private Card[] card;
	private int sign = -1;
//	private boolean checkQ = false;
	
	public CheckIn(InputStream in) {
		super();
		// TODO Auto-generated constructor stub
		s = new Scanner(in);
	}

	public boolean checkString(String str) {
		if(str == null)
			return false;
		String[] strs = str.split(" ");
		if(strs[0].equals("\\q")){
			card = null;
			return true;
		}
		if(strs.length == 0 || strs.length > 11)
			return false;
		card = new Card[strs.length];
		for (int i = 0; i < strs.length; i++) {
			if(strs[i].matches(CardData.getRegex())){
				setCard(strs, i);
			}else
				return false;
		}
		return true;
	}
	
	public boolean checkCards(){
		if(card == null){
			sign = -1;
			return true;
		}
		
		int num = card.length;
		
		if(num == 1){
			sign = 1;
			return true;
		}
		if(num == 2){
			if(card[0].equals(new Card("小王", "")) && card[0].equals(new Card("小王", ""))){
				sign = 0;
				return true;
			}
		}
		if(num == 4){
			if(checkEquals(0, 1, 4)){
				sign = 9;
				return true;
			}
		}
		if(num %2 == 0){
			if(checkEquals(0, num/2, 2) && checkIndex(0, num/2, 2)){
				sign = 2;
				return true;
			}
		}
		if(num % 3 == 0){
			if(checkEquals(0, num/3, 3) && checkIndex(0, num/3, 3)){
				sign = 3;
				return true;
			}
		}
		if(num % 4 == 0){
			if(checkEquals(0, num/4, 3) && checkIndex(0, num/4, 3)){
				sign = 4;
				return true;
			}
		}
		if(num % 5 == 0){
			if(checkEquals(0, num/5, 3) && checkIndex(0, num/5, 3) && 
					checkEquals(num/5*3, num/5, 2)){
				sign = 5;
				return true;
			}
		}
		if(num >= 5){
			if(checkIndex(0, num, 1)){
				sign = 1;
				return true;
			}
		}
		return false;
	}
	
	public boolean checkEquals(int start, int count, int len) {
		for (int i = start+len-1; i < start + count*len -1; i += len) {
			if(!card[i].equals(card[i+1]))
				return false;
		}
		return true;
	}
	
	public boolean checkIndex(int start, int count, int len) {
		if(card[start + len*count - 1].getIndex() >= 13)
			return false;
		for (int i = start+len-1; i < start + len*count -1; i += len) {
			if(card[i+1].getIndex() - card[i].getIndex() != 1)
				return false;
		}
		return true;
	}
	
//	public boolean checkNull(String[] strs){
//		if(strs[0].equals("\\q")){
//			checkQ = true;
//			return true;
//		}
//		return false;
//	}

	public void setCard(String[] strs, int i) {
		if(card == null)
			return;
		if(strs[i].equals("小王"))
			card[i] = new Card("小王", "");
		else if(strs[i].equals("大王"))
			card[i] = new Card("大王", "");
		else
			card[i] = new Card(strs[i].substring(2), 
					strs[i].substring(0, 2));
	}
	
	public boolean hasNextCards() {
		return s.hasNextLine();
	}
	
	public boolean checkNextCards() {
		return checkString(s.nextLine()) && checkCards();
	}
	
	public TempArg nextTempArg() {
		if(card == null)
			return null;
		return new TempArg(card, sign);
	}
	
	public void close() {
		s.close();
	}
}*/
