package cardgame;

public class Cards_ extends Cards {
	private int sign = -1;
	
	public Cards_(int sign) {
		super();
		this.sign = sign;
	}

	public boolean compareTo(Cards_ cards) {
		if(cards == null)
			return true;
		if(this.sign == cards.getSign() && this.getCount() == cards.getCount())
			return compareFirst(cards) > 0;
		return false;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}
	
}
