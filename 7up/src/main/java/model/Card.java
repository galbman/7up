package model;

import application.Util;
import reference.Suit;

public class Card {

	private final Suit suit;
	private final int number;
	
	public Card(Suit suit, int number) {
		if (number > 13 || number < 0) {
			throw new IllegalArgumentException("Number must be between 1 and 13");
		}
		this.suit = suit;
		this.number = number;
	}
	
	public Suit getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}
	
	public String toString() {
		return Util.convertCardNumber(number) + suit.getSymbol();
	}
}
