package cardgame;

public class CardsFactory {
	public static Cards_ CreateCards(TempArg arg) {
		if(arg == null)
			return null;
		
		
		Card[] cards = arg.getCards();
		int sign = arg.getSign();
		
		Cards_ c = null;
		if(sign == 0){
			c = new Cards_King();
		}
		else if(sign == 9){
			c = new Cards_4();
		}
		else if(sign == 1){
			c = new Cards_1();
		}
		else if(sign == 2){
			c = new Cards_2();
		}
		else if(sign == 3){
			c = new Cards_3();
		}
		else if(sign == 4){
			c = new Cards_3_1();
		}
		else if(sign == 5){
			c = new Cards_3_2();
		}
		
		if(cards == null)
			return null;
		for (int i = 0; i < cards.length; i++) {
			c.addCard(cards[i]);
		}
		return c;
	}

}
