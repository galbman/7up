package model;

import java.util.Set;
import java.util.Stack;

public class Player {

	private Set<Card> hand;
	private Set<Trick> tricks;
	private int bid;
	private int score;
	
	public void addCard(Card card){
		hand.add(card);
	}
	
	public void playCard(Card card){
		
	}
	
	public void returnTricks() {
		tricks.clear();
	}
}
