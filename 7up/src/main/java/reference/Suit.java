package reference;

public enum Suit {
	hearts ('\u2665'),
	spades ('\u2660'),
	clubs ('\u2663'),
	diamonds ('\u2666');
	
	private final char symbol;
	
	private Suit(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}

