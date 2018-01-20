package cardgame;

public class CheckCardArray {
	private CheckInput cin;
	private Card[] cardArray;
	private int sign = -1;

	public CheckCardArray() {
		super();
	}

	public CheckCardArray(CheckInput cin) {
		this.cin = cin;
	}

	private boolean checkArray() {

		if (cardArray == null) {
			sign = -1;
			return true;
		}

		int num = cardArray.length;

		if (num == 1) {
			sign = 1;
			return true;
		}
		if (num == 2) {
			if (cardArray[0].equals(new Card("小王", "")) && cardArray[0].equals(new Card("小王", ""))) {
				sign = 0;
				return true;
			}
		}
		if (num == 4) {
			if (checkEquals(0, 1, 4)) {
				sign = 9;
				return true;
			}
		}
		if (num % 2 == 0) {
			if (checkEquals(0, num / 2, 2) && checkIndex(0, num / 2, 2)) {
				sign = 2;
				return true;
			}
		}
		if (num % 3 == 0) {
			if (checkEquals(0, num / 3, 3) && checkIndex(0, num / 3, 3)) {
				sign = 3;
				return true;
			}
		}
		if (num % 4 == 0) {
			if (checkEquals(0, num / 4, 3) && checkIndex(0, num / 4, 3)) {
				sign = 4;
				return true;
			}
		}
		if (num % 5 == 0) {
			if (checkEquals(0, num / 5, 3) && checkIndex(0, num / 5, 3) && checkEquals(num / 5 * 3, num / 5, 2)) {
				sign = 5;
				return true;
			}
		}
		if (num >= 5) {
			if (checkIndex(0, num, 1)) {
				sign = 1;
				return true;
			}
		}
		return false;
	}

	private boolean checkEquals(int start, int count, int len) {
		for (int j = 0; j < count; j++) {
			for (int i = start + j*len; i < start + (j+1) * len - 1; i++) {
				if (!cardArray[i].equalsNum(cardArray[i + 1]))
					return false;
			}
		}
		return true;
	}

	private boolean checkIndex(int start, int count, int len) {
		if (cardArray[start + len * count - 1].getIndex() >= 13)
			return false;
		for (int i = start + len - 1; i < start + len * count - 1; i += len) {
			if (cardArray[i + len].getIndex() - cardArray[i].getIndex() != 1)
				return false;
		}
		return true;
	}

	private void nextCardArray() {
		while (true) {
			setCardArray(cin.nextCardArray());
			if (checkArray())
				break;
			System.out.println("牌不能这么出,请重新输入:");
		}
	}

	public TempArg nextTempArg() {
		nextCardArray();
		if (cardArray == null)
			return null;
		return new TempArg(cardArray, sign);
	}

	private void setCardArray(Card[] cardArray) {
		this.cardArray = cardArray;
	}

	public void setCin(CheckInput cin) {
		this.cin = cin;
	}

}
