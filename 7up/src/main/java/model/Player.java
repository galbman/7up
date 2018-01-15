package model;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import application.Util;

public class Player {

	private final int id;
	private final boolean isHuman;
	private final String name;
	private Set<Card> hand;
	private Set<Trick> tricks;
	private int bid;
	private int score;
		
	public Player(int playerNum, String name) {
		this.id = playerNum;
		if (Util.isEmpty(name)) {
			this.name = null;
			isHuman = false;
		} else {
			isHuman = true;
			this.name = name;
		}
		hand = new HashSet<Card>();
		tricks = new HashSet<Trick>();
	}
	
	public void addCard(Card card){
		hand.add(card);
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
	
	public Set<Card> getHand(){
		return hand;
	}
	
	public int getId() {
		return id;
	}
	
}
