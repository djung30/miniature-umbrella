
/***
    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run. Note anything notable.
    2. Move the "TOP" line down, so that it is below the first statement.
    (emacs: with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    (your editor: ???)
    3. Compile and run again.
    4. Resolve errors one at a time until it works.
    5. Repeat 2-4 until TOP meets BOTTOM.
***/

public class Driver {

  public static void main( String[] args ) {

    //build Objects from blueprint specified by class Coin

/*
    //test default constructor

      Coin mine = new Coin();
      //test 1st overloaded constructor
      Coin yours = new Coin( "quarter" );
      //test 2nd overloaded constructor
      Coin wayne = new Coin( "dollar", "heads" );
      //test toString() methods of each Coin
      System.out.println("mine: " + mine);
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test flip() method
      System.out.println("\nAfter flipping...");
      yours.flip();
      wayne.flip();
      System.out.println("yours: " + yours);
      System.out.println("wayne: " + wayne);
      //test equals() method
      if ( yours.equals(wayne) ) {
        System.out.println( "Matchee matchee!" );
      }
      else {
        System.out.println( "No match. Firestarter you can not be." );
      }
*/
	Coin e = new Coin();
	//x heads
	int x = 21;
	while (e.getHeadsCtr() < x) { 
		e.flip();
	}
	System.out.println("Flip Counter: " + e.getFlipCtr() + "\n");
	System.out.println("Heads Flip Counter: " + e.getHeadsCtr() + "\n");
	System.out.println("Tails Flip Counter: " + e.getTailsCtr() + "\n\n");
	
	//y matches
	e.reset("penny", 0.5);
	int y = 21;
	while (e.getFlipCtr() < y) {
		e.flip();
	}
	System.out.println("Flip Counter: " + e.getFlipCtr() + "\n");
	System.out.println("Heads Flip Counter: " + e.getHeadsCtr() + "\n");
	System.out.println("Tails Flip Counter: " + e.getTailsCtr() + "\n\n");
	
	e.reset("penny", 0.5);
	
	while ((e.getFlipCtr() < 65536) && ) {
		e.flip();
	}
	System.out.println("Flip Counter: " + e.getFlipCtr() + "\n");
	System.out.println("Heads Flip Counter: " + e.getHeadsCtr() + "\n");
	System.out.println("Tails Flip Counter: " + e.getTailsCtr() + "\n");
	
	
  }//end main()

}//end class
