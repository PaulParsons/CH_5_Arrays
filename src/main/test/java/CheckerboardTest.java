import static org.junit.jupiter.api.Assertions.assertTrue;

import exercises.Checkerboard;
import org.junit.jupiter.api.Test;

public class CheckerboardTest {

	private Checkerboard checkerBd;

	@Test
	public void initCheckerBoardTest() {
		// Verifies count of Red and Black checkers
		checkerBd = new Checkerboard();

		checkerBd.initCheckerBoard();
		int blackCount = 0;  //count of black checker pieces
		int redCount = 0;  //count of red checker pieces

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				//count checker pieces on board
				if ((checkerBd.checkerBoard[row][col].equals("B"))){
					blackCount++;
				}
				else if ((checkerBd.checkerBoard[row][col].equals("R"))){
					redCount++;
				}
			}
		}
		//check for 12 black checkers and 12 red checkers
		assertTrue(blackCount==12 && redCount==12);
	}

	@Test
	public void printCheckerBoardTest() {
		//Verifies initial checkerboard pieces
		checkerBd = new Checkerboard();
		checkerBd.initCheckerBoard();
		//check to make sure that the initial checkerboard string is correct
		assertTrue(checkerBd.toString().equals("B   []  B   []  B   []  B   []  \n[]  B   []  B   []  B   []  B   \nB   []  B   []  B   []  B   []  \n[]  []  []  []  []  []  []  []  \n[]  []  []  []  []  []  []  []  \n[]  R   []  R   []  R   []  R   \nR   []  R   []  R   []  R   []  \n[]  R   []  R   []  R   []  R   \n"));
	}
}