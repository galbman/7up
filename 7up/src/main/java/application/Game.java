package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import model.Card;
import model.Player;
import reference.Suit;

public class Game {

	private Stack<Card> deck;	
	private List<Player> players;
	
	
	public Game(int numPlayers) {
		System.out.println("launching game for " + numPlayers + "players...");
		players = new ArrayList<Player>();
		for (int i = 0; i < numPlayers; i++){
			players.add(new Player(i, ""));
		}
		System.out.println("building deck...");
		buildDeck();
		System.out.println("generated deck: " + deck);
		
		for (int i = 1; i <= 14; i++) {
			playHand(i);
		}
		//call play hand method appropriate number of times
		//cycle who is first
		//inside hand method, 
	}		
	
	private void buildDeck() {
		deck = new Stack<Card>();
		for (Suit suit : Suit.values()) {
			for (int val = 1; val <= 13; val++) {
				Card card = new Card(suit, val);
				deck.add(card);
			}
		}
		Collections.shuffle(deck);
	}
			
	private void playHand(int handNum) {
		int handSize;
		Card trump = deck.pop(); 
		if (handNum < 8) {
			handSize = 8 - handNum;
		} else {
			handSize = handNum - 7;
		}
		for (int i = 0; i < handSize; i++) {
			for (Player p : players) {
				p.addCard(deck.pop());
			}
		}
		
		System.out.println("round " + handNum +", dealt " + handSize  + " cards.  Trump is: " + trump);
		for (Player p : players) {
			System.out.println("player " + p.getId() + " hand:");
			System.out.println(p.getHand());
		}		
		
		
		//get bids
		for (Player p : players) {
			System.out.println("player " + p.getId() + " bids " + p.makeBid());
		}
		
		//play
		//high bid goes first
		//plays card, trick is created
		//
				
		cleanUpHand();				
	}
	
	private void cleanUpHand() {
		for (Player p : players) {
			p.finishHand();
		}
		buildDeck();
	}
	
}
