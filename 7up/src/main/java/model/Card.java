package model;

import application.Util;
import reference.Suit;

public class Card {

	private final Suit suit;
	private final int value;
	private final String display;
	
	public Card(Suit suit, int value) {
		if (value > 13 || value < 0) {
			throw new IllegalArgumentException("Number must be between 1 and 13");
		}
		this.suit = suit;
		this.value = value;
		this.display = convertCardNumber(value);
		
	}
	
	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}
	
	public String toString() {
		return display + suit.getSymbol();
	}
	
	private String convertCardNumber(int val) {
		if (val > 0 && val < 11) {
			return Integer.toString(val);
		}
		if (val == 11) 
			return "J";
		if (val == 12) 
			return "Q";
		if (val == 13) 
			return "K";
		else 
			throw new IllegalArgumentException("Card val must be between 1 and 13");
	}
}
