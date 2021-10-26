
/***
 * Daniel Jung (Dunking Ducks: Roster: Jason Zhou, Daniel Jung, Tiggy, Ralph)
 * APCS
 * HW24: Get It While You Can (Edited Driver.java)
 * 2021 - 10 - 25
 * Time spent: In class time + 8 minutes outside class
 * 
 * Disco: N/A
 * QCC: N/A
 * POST-v0 MODS: N/A
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
    e.flip();
    
      while ((e.getFlipCtr() < 65535) || ((e.getFlipCtr() % 2005) != 0)) {
        e.flip();
        System.out.println(e.getFlipCtr());
    }
      System.out.println("Flip Counter: " + e.getFlipCtr() + "\n");
      System.out.println("Heads Flip Counter: " + e.getHeadsCtr() + "\n");
      System.out.println("Tails Flip Counter: " + e.getTailsCtr() + "\n\n");
      
      
    }//end main()
  
  }//end class
