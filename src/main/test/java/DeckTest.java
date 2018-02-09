import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import exercises.Deck;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {

	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStream() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void cleanupStream() {
		System.setOut(null);
	}

	/*
	@Test
	public void buildDeckTest() {
		Deck deck = new Deck();
		deck.buildDeck();

		for (int i = 1; i <= 52; i++) {
			assertTrue(!deck.drawCard().isEmpty());
		}
	}

	@Test
	public void drawCardTest() {
		Deck deck = new Deck();

		assertEquals(deck.getDeckPosition(), 0);
		deck.drawCard();
		assertEquals(deck.getDeckPosition(), 1);

		for (int i = 0; i < 100; i++) {
			deck.drawCard();
		}
		assertEquals(deck.getDeckPosition(), 52);
	}

	@Test
	public void printDeckTest() {
		Deck deck = new Deck();
		deck.buildDeck();
		deck.printDeck();
		assertTrue(outContent.toString().contains("3 of Clubs"));
	}
*/
	//TODO shuffle() unit tests.

}
