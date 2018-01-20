package cardgame;

import java.util.ArrayList;
import java.util.Random;

public class AllCard {
	private ArrayList<Card> allCard = new ArrayList<Card>();
	private static Random r = new Random();

	public AllCard() {
		super();
	}

	public ArrayList<Card> getAllCard() {
		return this.allCard;
	}

	public void updataAllCard() {
		this.allCard.addAll(CardData.getAllCard());
	}
	
	public Card nextCard() {
		if(allCard.size() == 1)
			return allCard.remove(0);
		if(allCard.size() != 0){
			return allCard.remove(r.nextInt(allCard.size()-1));
		}
		return null;
	}
	
	public boolean hasNextCard() {
		if(allCard.size() != 0)
			return true;
		return false;
	}
	
	public int remainCardCount() {
		return this.allCard.size();
	}
	
	@Override
	public String toString() {
		return "[allCard=" + allCard + "]";
	}

}
