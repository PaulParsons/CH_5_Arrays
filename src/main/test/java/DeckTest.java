import exercises.Deck;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
		deck.buildDeck();
		//I've expanded the deckPosition instance variable to handle the case of no cards left in deck

		assertEquals(deck.getDeckPosition(), 1);
		deck.drawCard();
		assertEquals(deck.getDeckPosition(), 2);

		for (int i = 0; i < 100; i++) {
			deck.drawCard();
		}

		assertEquals(deck.getDeckPosition(), 0);
	}

	@Test
	public void printDeckTest() {
		Deck deck = new Deck();
		deck.buildDeck();
		deck.printDeck();
		assertTrue(outContent.toString().contains("3 of Clubs"));
	}


	@Test
	public void shuffleTest(){
		//verifies that shuffling the deck changes the card order
		Deck deck = new Deck();
		deck.buildDeck();
		String firstDraw = "";
		String secondDraw = "";
		int match = 0; //number of times a draw-shuffle-draw produces the same card
		int drawTotal = 100000;  //number of times to draw-shuffle-draw checking for a match
		// draw a card, shuffle deck, then draw a new card, verify that those two top cards are not the same 96% of the time
		for (int i=0;i<drawTotal;i++){
			deck.shuffle();
			firstDraw = deck.drawCard();
			deck.shuffle();
			secondDraw = deck.drawCard();
			if (firstDraw.compareTo(secondDraw)==0){
				match++;
			}
		}
		assertTrue(((match/drawTotal)*100)<4.0);

	}
}
