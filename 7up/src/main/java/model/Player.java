package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import application.Util;

public class Player {

	private final int id;
	private final boolean isHuman;
	private final String name;
	private List<Card> hand;
	private Set<Trick> tricks;
	private int bid;
	private int score;
	private Player nextPlayer;
		
	public Player(int playerNum, String name) {
		this.id = playerNum;
		if (Util.isEmpty(name)) {
			this.name = null;
			isHuman = false;
		} else {
			isHuman = true;
			this.name = name;
		}
		hand = new ArrayList<Card>();
		tricks = new HashSet<Trick>();
	}
	
	public void addCard(Card card){
		int index = getNewCardPosition(card);
		hand.add(index, card);
	}
	
	private int getNewCardPosition(Card newCard) {
		int index = 0;
		if (!hand.isEmpty()) {
			int thisRank = newCard.getSuit().getRank();
			for (int i = 0; i < hand.size(); i++) {
				index = i;
				Card checkCard = hand.get(i);
				if (thisRank == checkCard.getSuit().getRank()) {
					if (newCard.getValue() < checkCard.getValue()) {
						break;
					} else {
						index = i + 1;
					}
				} else if (thisRank < checkCard.getSuit().getRank()) {
					break;
				} else {
					index = i + 1;
				}
			}
		}
		return index;
	}
	
	public void playCard(Card card){
		
	}
	
	public void finishHand() {
		hand.clear();
		tricks.clear();
	}
		
	public int makeBid() {
		if (isHuman) {
			boolean goodBid = false;
			String input = "";
			while(!goodBid) {
				System.out.print(name + ", enter your bid:");
				input = System.console().readLine();
				try {
					bid = Integer.parseInt(input);
					goodBid = true;
				} catch (Exception e) {
					System.out.println("[" + input + "] is not a valid bid.");
				}
			}
		} else {
			bid = 1;
		}
		
		return bid;
	}
	
	public List<Card> getHand(){
		return hand;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
	
	public Player getNextPlayer() {
		return nextPlayer;
	}
	
}
