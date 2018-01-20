package cardgame;

public class TempArg {
	private Card[] cards;
	private int sign;

	public TempArg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TempArg(Card[] cards, int sign) {
		super();
		this.cards = cards;
		this.sign = sign;
	}

	public Card[] getCards() {
		return cards;
	}

	public int getSign() {
		return sign;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}
}
