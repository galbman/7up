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
			players.add(new Player());
		}
		System.out.println("building deck...");
		buildDeck();
		System.out.println("generated deck: " + deck);
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
		
}
