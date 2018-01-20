package cardgame;

public class Cards_4 extends Cards_ {

	public Cards_4() {
		super(9);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean compareTo(Cards_ cards) {
		// TODO Auto-generated method stub
		if(super.compareTo(cards))
			return true;
		if(cards.getSign() != 2)
			return true;
		return false;
	}

}
