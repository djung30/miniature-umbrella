/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card one = new Card("king", "spades", 13);
		Card two = new Card("queen", "diamonds", 13);		
		Card three = new Card("king", "spades", 13);		

		System.out.println(three.toString());
		
		System.out.println("Comparing Card 2 to Card 1 " + two.matches(one));
		System.out.println("Comparing Card 2 to Card 3 " + two.matches(three));
		System.out.println("Comparing Card 1 to Card 3 " + one.matches(three));

	}
}
