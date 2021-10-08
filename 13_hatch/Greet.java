public class Greet {
  public static void main( String[] args ) {
    
    BigSib richard = new BigSib("Word up");
    System.out.println(richard.greet("freshman"));

    BigSib prichard = new BigSib("Salutations");
    System.out.println(prichard.greet("Dr. Spaceman"));

    BigSib brichard = new BigSib("Hey ya");
    System.out.println(brichard.greet("Kong Fooey"));

    BigSib qrichard = new BigSib("Sup");
    System.out.println(qrichard.greet("mom"));

  } //end main()
} //end Greet
