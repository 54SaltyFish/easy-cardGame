package cardgame;

import java.util.Random;

public class CardGame {
	private Player[] players;
	private int id;
	private int count = 0;
	private AllCard allCard;
	private Cards_ lastCards;
	private Cards_ newCards;
	private CheckCardArray cca;
	private boolean sign = true;

	public CardGame() {
		super();
		// TODO Auto-generated constructor stub
		allCard = new AllCard();
	}

	public CardGame(Player p1, Player p2, Player p3) {
		this();
		this.players = new Player[] { p1, p2, p3 };
	}

	public void setCheckCardArray(CheckCardArray cca) {
		this.cca = cca;
	}
	
	public void setAllCard() {
		this.allCard.updataAllCard();
	}
	
	public void dealCard() {
		while (true) {
			if (allCard.remainCardCount() <= 3)
				break;
			for (int i = 0; i < 3; i++) {
				players[i].addCard(allCard.nextCard());
			}
		}
		setDiZhu();
		while (allCard.hasNextCard())
			this.players[this.id].addCard(allCard.nextCard());
		for (int i = 0; i < players.length; i++) {
			players[i].sortCards();
		}
	}

	private void setDiZhu() {
		Random r = new Random();
		this.id = r.nextInt(3);
		System.out.println("地主是玩家" + this.players[this.id].getName());
	}

	private boolean checkWin(int index) {
		if (!players[index].hasCard()) {
			System.out.println("玩家" + players[index] + "赢了");
			return true;
		}
		return false;
	}

	private void setNewCards(int index) {
		newCards = CardsFactory.CreateCards(cca.nextTempArg());
	}

	private boolean checkNewCards(int index) {
		if (newCards == null) {
			if (sign == true && lastCards == null){
				System.out.print("您先手!");
				return false;
				}
			return true;
		}
		if (!players[index].hasCards(newCards)) {
			System.out.print("您没有这些牌!");
			return false;
		}
		if (!newCards.compareTo(lastCards)) {
			System.out.print("您出的牌小了!");
			return false;
		}
		return true;
	}

	private void nextNewCards(int index) {
		while (true) {
			setNewCards(index);
			if (checkNewCards(index))
				break;
			System.out.println("请重新出牌:");
		}
	}

	private void putCards(int index) {
		if (newCards == null) {
			System.out.println(players[index].getName() + "什么都没出.");
			if (sign)
				lastCards = null;
			sign = true;
			count++;
			return;
		}

		players[index].put(newCards);
		System.out.println(players[index].getName() + "打出了:");
		System.out.println(newCards);
		lastCards = newCards;
		sign = false;
		count++;
	}

	public boolean nextPlayer() {
		int index = count % 3;
		System.out.println(
				"第" + (count / 3 + 1) + "轮次第" + index + "位玩家" + players[index].getName() + "出牌.");
		players[index].show();
		nextNewCards(index);
		putCards(index);
		return checkWin(index);
	}

	public void gameRun() {
		setAllCard();
		dealCard();
		while (true) {
			if(nextPlayer())
				break;
		}
		System.out.println("游戏结束");
	}

}
