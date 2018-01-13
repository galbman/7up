package model;

import java.util.Set;

public class Trick {

	private Set<Card> cards;
	
	public void addCard(Card card) {
		cards.add(card);
	}
}
