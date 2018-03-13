package exercises;

public class Deck {

	/*
	 * Create a class named exercises.Deck that contains the following:
	 * - An integer value named deckPosition signifying the current "top" of the deck.
	 * - A String array that holds all of the cards in the deck.
	 *
	 * - A method named buildDeck() that fills a String array with all 52 cards.
	 * --NOTE: You should NOT be typing out all 52 card's. Use arrays and for-each loops.
	 * -- Cards should be in the format of:
	 * -- [value] of [suit]
	 * Ex. Jack of Hearts, 9 of Diamonds
	 *
	 * - A method named shuffle() that shuffles the deck.
	 * --NOTE: You can make this as simple or complex as you choose. Swapping the first 2 cards within the deck
	 * is technically considered a shuffle. But so is swapping randomly selected cards 1000 times.
	 *
	 * - A drawCard() method that "draws" the next card from the top of the deck and returns the string of the card. Getter and
	 * setter methods should be used here.
	 * --NOTE: In this situation the TOP of the deck will start at array index 0.
	 * -- You should NOT be able to draw past the end of the deck.
	 *
	 * - A printDeck() method that prints out every card, one per line.
	 * -- Example:
	 *    King of Spades
	 *    Ace of Diamonds
   *    2 of Diamonds
   *    3 of Diamonds
   *
   * -- In the DeckTest class, create your own unit tests for the shuffle() method.
	 *
	 */


		private int deckPosition;  //zero means there are no cards in deck; 1 thru 52 is the current card at the top of deck
		String cardDeck[] = new String[52];
		String suits[] = {"Hearts","Spades","Diamonds","Clubs"};
		String ranks[] = {"Ace","King","Queen","Jack","10","9","8","7","6","5","4","3","2",};

		public void buildDeck() {
			// build a deck of cards (unshuffled)
			int x = 0; //card counter
			for (String rankStr : ranks) {
				for (String suitStr : suits) {
					cardDeck[x++] = rankStr + " of " + suitStr;
				}
			}
			setDeckPosition(1);  //first card is top card
		}

		public void setDeckPosition(int position){
			//set the instance var deckPosition; it indicates the top of the deck card number (starting at card #1)
			if ((position >= 0) && (position <= 52)) {
				deckPosition = position;
			}
			else{
				deckPosition = 0;
			}
		}

		public int getDeckPosition(){
			//retrieve the array index of the top of the deck
			return(deckPosition);
		}

		public void printDeck() {
			// Prints the current card deck
			int topCard = getDeckPosition();

			if (topCard == 0){
				System.out.println("There are no cards in the deck.");
			}
			else{
				for (int i = topCard-1; i < cardDeck.length; i++) {
					System.out.println("Card #"+ (i+1) + ":  " + drawCard());
				}
				setDeckPosition(topCard);
			}
		}

		public String drawCard(){
			// draw a card from top of deck
			// that card is no longer considered part of the deck by moving the deckPosition counter
			// thus 'discarding' the top of the deck
			int topCardIndex = getDeckPosition()-1;
			if (topCardIndex < 0) {
				return(null);
			}
			else {
				setDeckPosition(getDeckPosition()+1);
				return (cardDeck[topCardIndex]);
			}

		}

		public void shuffle(){
			//shuffle the deck of cards by swapping each card position with a random position
			int n = cardDeck.length;
			for (int i = 0; i < n; i++) {
				int r = i + (int) (Math.random() * (n-i));
				String temp = cardDeck[r];
				cardDeck[r] = cardDeck[i];
				cardDeck[i] = temp;
			}
			setDeckPosition(1);  //reset top card to first card in deck
		}

		public static void main (String args[]){
			Deck d1 = new Deck();
			d1.buildDeck();
			System.out.println("Unshuffled Deck:\n");
			d1.printDeck();
			d1.shuffle();
			System.out.println("\nShuffled Deck:\n");
			d1.printDeck();
			String pickACard = d1.drawCard();
			System.out.println("\nPick a Card from the top of the deck: " + pickACard);
		}
	}
