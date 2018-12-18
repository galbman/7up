import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

import model.Card;
import model.Player;
import reference.Suit;

public class DealTest {

	@Test
	public void testOrdering() {
		Player p = new Player(0, "");
		Card c1 = new Card(Suit.hearts, 2);
		Card c2 = new Card(Suit.hearts, 3);
		p.addCard(c1);
		p.addCard(c2);
		verifyHandOrder(p.getHand());
	}
	
	@Test
	public void testOrdering2() {
		Player p = new Player(0, "");
		Card c1 = new Card(Suit.hearts, 3);
		Card c2 = new Card(Suit.hearts, 2);
		p.addCard(c1);
		p.addCard(c2);
		verifyHandOrder(p.getHand());
	}
	
	
	private void verifyHandOrder(List<Card> hand) {
		if (hand == null || hand.isEmpty()) {
			throw new IllegalArgumentException("Cannot verify order- hand is empty");
		}
		for (int i = 0; i < hand.size(); i++) {
			if (i != 0) {
				Card testCard1 = hand.get(i-1);
				Card testCard2 = hand.get(i);
				assertTrue(
					testCard1.getSuit().getRank() < testCard2.getSuit().getRank()
					|| (testCard1.getSuit().getRank() == testCard2.getSuit().getRank()
						&& testCard1.getValue() < testCard2.getValue()));						
			}
		}
	}
		
}
