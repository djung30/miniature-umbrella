/**
 * This class provides a convenient way to test shuffling methods.
 */

/*
3) 0, 1, 1
*/

public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 10;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static String flip() {
		if (Math.random() > 0.33) {
			return "tails";
		};
		return "heads";
	}

	public boolean arePermutations (int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i : a) {
			for (int j : b) {
				if (i == j) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int mid = (values.length + 1) / 2;
		int[] firstHalf = new int[mid];
		int[] secondHalf = new int[values.length / 2];

		for (int i = 0; i < mid; i++) {
			firstHalf[i] = values[i];
		}

		for (int i = mid; i < values.length; i++) {
			secondHalf[i - mid] = values[i];
		}

		int k = 0;

		for (int j = 0; j < firstHalf.length; j++) {
			values[k] = firstHalf[j];
			k += 2;
		}

		k = 1;
		for (int j = 0; j < secondHalf.length; j++) {
			values[k] = secondHalf[j];
			k += 2;
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for (int i = values.length - 1; i > 0; i--) {
			int r = (int) (Math.random() * (i + 1));
			int temp = values[r];
			values[r] = values[i];
			values[i] = temp;
		}
	}
}
