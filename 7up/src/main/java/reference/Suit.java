package reference;

public enum Suit {
	hearts ('\u2665', 0),
	spades ('\u2660', 1),
	clubs ('\u2663', 2),
	diamonds ('\u2666', 3);
	
	private final char symbol;
	private final int rank;
	
	private Suit(char symbol, int rank) {
		this.symbol = symbol;
		this.rank = rank;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public int getRank() {
		return rank;
	}
}

