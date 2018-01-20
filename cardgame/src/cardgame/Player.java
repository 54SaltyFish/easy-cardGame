package cardgame;

public class Player {
	private String name;
	private Cards cards;
	
	public Player(String name) {
		super();
		this.name = name;
		this.cards = new Cards();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cards getCards() {
		return cards;
	}

	public void setCards(Cards cards) {
		this.cards = cards;
	}
	
	public void sortCards() {
		this.cards.sort();
	}
	
	public boolean addCard(Card card) {
		return this.cards.addCard(card);
	}
	
	public boolean put(Cards cards){
		return this.cards.remove(cards);
	}

	public boolean hasCards(Cards cards) {
		if(cards == null)
			return true;
		return this.cards.contains(cards);
	}
	
	public void show() {
		System.out.println(this);
	}
	
	public boolean hasCard() {
		return cards.getCount() != 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + ":" + this.cards;
	}
}
