/**
 * This is a class that tests the Deck class.
 */

/*
1) A Deck contains a collection of Cards.
2) 6 cards
3) String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",  "jack", "queen", "king", "ace"}; 
   String[] suits = {"spades", "hearts", "diamonds", "clubs"}; 
   int[] pointValues = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
4) Order doesn't matter, but the respective ordering for ranks and pointValues should be the same.
   */

public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 * 
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] ranks = { "jack", "queen", "king" };
		String[] suits = { "blue", "red" };
		int[] pointValues = { 11, 12, 13 };

		Deck one = new Deck(ranks, suits, pointValues);

		String[] ranks1 = { "ace", "queen", "jack" };
		String[] suits1 = { "blue", "red" };
		int[] pointValues1 = { 1, 12, 11 };

		Deck two = new Deck(ranks1, suits1, pointValues1);

		String[] ranks2 = { "queen", "queen", "jack" };
		String[] suits2 = { "blue", "red" };
		int[] pointValues2 = { 12, 12, 11 };

		Deck three = new Deck(ranks2, suits2, pointValues2);
		System.out.println(one.size());
		System.out.println(one.deal());
		System.out.println(one.size());

		System.out.println(two.size());
		System.out.println(two.deal());
		System.out.println(two.size());

		System.out.println(three.size());
		System.out.println(three.deal());
		System.out.println(three.size());
	}
}
