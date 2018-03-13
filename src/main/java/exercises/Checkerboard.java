package exercises;

public class Checkerboard {

	/*
	 * Create a class that builds an 8 x 8 checkerboard and fills it with
	 * a set of checkers game pieces in their starting positions.
	 *
	 * A 2-dimensional array should be used for the board.
	 *
	 * The class should also have the ability to print your board in a readable
	 * fashion. My output looks like this:
	 *
	 *  B			[]		B			[]		B			[]		B			[]
			[]		B			[]		B			[]		B			[]		B
			B			[]		B			[]		B			[]		B			[]
			[]		[]		[]		[]		[]		[]		[]		[]
			[]		[]		[]		[]		[]		[]		[]		[]
			[]		R			[]		R			[]		R			[]		R
			R			[]		R			[]		R			[]		R			[]
			[]		R			[]		R			[]		R			[]		R

			Feel free to mimic that exactly if you like the look of it.

			Create a class in the test directory and write at least 2 unit tests for your class.


	 checkerBoard array member can include
	 "B" = Black Checker
	 "R" = Red Checker
	 "BK" = Black King
	 "RK" = Red King
	 "[]"= empty square
*/
	public String[][] checkerBoard = new String[8][8];

	public void initCheckerBoard() {
		String checker = "";

		//initializes the current checkerboard (I call this Case madness)
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				switch (row) {
					//Black checkers in rows 0,1,2
					case 0:
					case 2:
						if (col % 2 == 0) {
							//first row and all even rows
							checkerBoard[row][col] = "B";
						} else {
							checkerBoard[row][col] = "[]";
						}
						break;
					case 1:
						if (col % 2 != 0) {
							//all odd rows
							checkerBoard[row][col] = "B";
						} else {
							checkerBoard[row][col] = "[]";
						}
						break;
					case 5:
					case 7:
						//red checkers in rows 5,6,7
						if (col % 2 != 0) {
							//all odd rows
							checkerBoard[row][col] = "R";
						} else {
							checkerBoard[row][col] = "[]";
						}
						break;
					case 6:
						if (col % 2 == 0) {
							//first row and all even rows
							checkerBoard[row][col] = "R";
						} else {
							checkerBoard[row][col] = "[]";
						}
						break;
					default:
						checkerBoard[row][col] = "[]";
						break;
				}
			}
		}
	}

	@Override
	//overrides toString for the checkerBoard object - converting the 2D array into a formatted string
	// completely Kyli's idea here so we could do a much sweeter unit test
	public String toString() {
		StringBuilder sBuf = new StringBuilder();

		//reads the checkerboard and appends a formatted String
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				sBuf.append(String.format("%-4s",checkerBoard[row][col]));
			}
			sBuf.append("\n");
		}
		return(sBuf.toString());
	}

	public void printCheckerBoard(){
		//prints the checkerboard
		System.out.println(this.toString());
	}


	public static void main(String args[]) {
		Checkerboard cb = new Checkerboard();
		cb.initCheckerBoard();
		cb.printCheckerBoard();
	}

}
