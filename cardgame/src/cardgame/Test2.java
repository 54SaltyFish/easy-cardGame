package cardgame;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player p1 = new Player("赵");
		Player p2 = new Player("钱");
		Player p3 = new Player("孙");
		CardGame cg = new CardGame(p1, p2, p3);
		cg.gameRun();
		p1.sortCards();
		p2.sortCards();
		p3.sortCards();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		
//		Player p1 = new Player("赵");
//		Player p2 = new Player("钱");
//		Player p3 = new Player("孙");
//		CardGame cg = new CardGame(p1, p2, p3);
//		cg.allCard.updataAllCard();
//		System.out.println(cg.allCard);
//		cg.setDiZhu();
//		cg.dealCard();
//		System.out.println(cg.allCard);
//		p1.sortCards();
//		p2.sortCards();
//		p3.sortCards();
//		System.out.println(p1);
//		System.out.println(p2);
//		System.out.println(p3);
		
//		AllCard ac = new AllCard();
//		ac.updataAllCard();
	}

}
