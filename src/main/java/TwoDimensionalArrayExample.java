public class TwoDimensionalArrayExample {

	public static void main(String[] args) {
		int[][] tableOfNumbers = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tableOfNumbers[i][j] = i + j;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("[" + tableOfNumbers[i][j] + "] ");
			}
			System.out.print("\n");
		}

		int[][] tableOfNumbers2 = {
																{1, 2},
																{3, 4},
																{5, 6}
															};
	}

}
