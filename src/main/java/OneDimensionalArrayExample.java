public class OneDimensionalArrayExample {

	public static void main(String[] args) {
		int[] numbers = new int[10]; // Declare new array using single statement

		int[] numbers2;
		numbers2 = new int[10]; // Declare new array using two statements

		for(int i = 0; i < 10; i++) { // Initialize using for loop
			numbers[i] = i;
			numbers2[i] = i;
		}

		// Declare and initialize in single line
		int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

	}

	public void example() {
		int[] numbers = new int[10];

		for(int i = 0; i < 10; i++) {
			numbers[i] = i;
		}
	}

}
