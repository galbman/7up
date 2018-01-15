package model;

import java.util.HashSet;
import java.util.Set;

import reference.Suit;

public class Trick {

	private Set<Card> cards;
	private Suit lead;
	
	public Trick(Card card) {
		cards = new HashSet<Card>();
		cards.add(card);
		lead = card.getSuit();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
}
