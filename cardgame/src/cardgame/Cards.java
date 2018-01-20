package cardgame;

import java.util.ArrayList;
import java.util.Collections;

public class Cards {
	private ArrayList<Card> cards;
	
	public Cards() {
		super();
		// TODO Auto-generated constructor stub
		cards = new ArrayList<Card>();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public boolean addCard(Card card) {
		return this.cards.add(card);
	}
	
	public int getCount() {
		return this.cards.size();
	}
	
	public int compareFirst(Cards cards) {
		return this.getCards().get(0).compareTo(cards.getCards().get(0));
	}
	
	public boolean contains(Cards cards) {
		return this.cards.containsAll(cards.getCards());
	}

	public boolean remove(Cards cards) {
		return this.cards.removeAll(cards.getCards());
	}
	
	public void sort() {
		Collections.sort(this.cards);
	}
	
	public void show() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.cards;
	}
}
