package 디자인패턴.상태패턴;

public class VendingMachine {
	public static enum State { NOCOIN, SELECTABLE }

	private State state = State.NOCOIN;

	public void insertCoin(int coin) {
		switch(state) {
			case NOCOIN:
				increaseCoin(coin);
				state = State.SELECTABLE;
				break;
			case SELECTABLE:
				increaseCoin(coin);
		}
	}

	public void select(int productId) {
		switch (state) {
			case NOCOIN:
				// 아무것도 하지 않음
				break;
			case SELECTABLE:
				provideProduct(productId);
				decreaseCoin();
				if (hasNoCoin())
					state = State.NOCOIN;
		}
	}

	private void increaseCoin(int coin) {
		// ...
	}

	private void provideProduct(int productId) {
		// ...
	}

	private void decreaseCoin() {
		// ...
	}

	private boolean hasNoCoin() {
		// ...
		return true;
	}
}
