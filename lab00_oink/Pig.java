/***
 * V3: add da scanner!!!!!!! + fixed hasAvowel and other tweaks
 * Jason Zhou, Daniel Jung, Russell Goychayev (Team Dunkin' Ducks) Duckies: Tiggy, Ralph, 
 * APCS
 * L00: Etterbay Odingcay Oughthray Ollaborationcay (Created Pig Latin translator)
 * 2021-11-09
 * time spent: 1 hrs
 * 
 * DISCO: hasVowels does not work
 * Q: n/a
 * 
 * HOW WE UTILIZED SCANNER DEMO in v3: 
 *      We had it read every input and for every
 *      input we called engToPig. We seperated each
 *      output by spaces
 * 
 * 
 * WHAT CAUSES THE RUNTIME ERROR IN THE SCANNER DEMO:
 *      System.out.println( sc.next() );
        System.out.println( sc.next() );
        is the source of error. 
        Given: 
        Hey 
        Boi
        The first time main runs it see: sc has next?
        It sees that Hey exists so it procedes. Then main prints
        the next line so it prints out Hey, then Boi. The while loop
        then runs again and sees that Boi is next. So it prints out sc.next.
        However sc.next doesn't exist and you get an error. (NoSuchElementException)
)
        The way to fix this just to set an variable to store inputs 
        as shown in our main
        NEW IN v3
 * 
 */
import java.util.Scanner;

public class Pig
{
  private static final String VOWELS = "aeiouy";


  /**
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p") -> false
  **/
  public static boolean hasA( String w, String letter ) {

    return w.indexOf(letter) != -1;

    /* equiv code, wo using indexOf()...
       boolean ans = false;
       for( int i = 0; i < w.length(); i++ ) {
       if ( w.substring(i,i+1).equals(letter) ) {
       ans = true;
       //Q: is there a more efficient way?
       }
       }
       return ans;
    */
  }//end hasA()


  /**
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    **/
  public static boolean isAVowel( String letter ) {
    return VOWELS.indexOf( letter ) != -1;
  }


  /**
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    **/
  public static int countVowels( String w ) {

    return allVowels(w).length();

    /* long version using for
       int numVowels = 0; //init vowels counter var
       //must touch each letter in word, so use FOR
       for( int i = 0; i < w.length(); i++ ) {
       if ( isAVowel( w.substring(i,i+1) ) )
       numVowels++;
       }
       return numVowels;
    */
  }


  /**
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz") -> false
    **/
  public static boolean hasAVowel( String w ) {
    // does not work sadly 
    // return w.indexOf(w) >= 0;
    return allVowels(w).length() > 0;

  }


  /**
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    **/
  public static String allVowels( String w ) {

    String ans = ""; //init return String

    for( int i = 0; i < w.length(); i++ ) {

      if ( isAVowel( w.substring(i,i+1) ) )
        ans += w.substring( i, i+1 ); //grow the return String
    }
    return ans;
  }


  /**
    String firstVowel(String) -- returns first vowel in a String
    pre:  w != null
    post: firstVowel("") --> ""
    firstVowel("zzz") --> ""
    firstVowel("meatball") --> "e"
    **/
  public static String firstVowel( String w ) {

    String ans = "";

    if ( hasAVowel(w) ) {//Q: Why this necess? 
      ans = allVowels(w).substring(0,1);
    }
    return ans;
  }


  /**
    boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
    pre:  w != null and w.length() > 0
    post: beginsWithVowel("apple")  --> true
    beginsWithVowel("strong") --> false
    **/
  public static boolean beginsWithVowel( String w ) {
    return isAVowel( w.substring(0,1) );
  }


  /**
    String engToPig(String) -- converts an English word to Pig Latin
    pre:  w.length() > 0
    post: engToPig("apple")  --> "appleway"
    engToPig("strong") --> "ongstray"
    engToPig("java")   --> "avajay"
    **/
  public static String engToPig( String w ) {
    
    /*
    Deals with punc, ie: pinoochio, becomes pinoochio so its easier to work w/
    Monkey, .Pig
    */
    String punc = "";
    boolean hasPunc = false;
    if (hasPunc(w)) {
        punc = w.substring(w.length()-1);
        w = w.substring(0, w.length()-1);
        
        hasPunc = true;
    }

    String ans = "";
    //case of 1 letter 
    if (w.length() == 1) {
        ans = w + "ay";
    }
    
    //If first letter is y, append "yay" 
    else if ( w.substring(0, 1).equals("y") ) {
        ans = w.substring(1) + "yay";
    }
    //If beings with vowel, append "way"
    else if ( beginsWithVowel(w) ) { 
        ans = w + "way";
    }
    //Capitalization for more than one letter
    else if (hasUpper(w) && w.length() != 1) {
        String upperCase = w.substring(1, 2).toUpperCase(); //Ex: Pig, i becomes capital
        ans = upperCase + w.substring(2) + w.substring(0, 1).toLowerCase() + "ay";
    } 
    //Normal cases 
    else {
       
        int vPos = w.indexOf( firstVowel(w) );
        ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
        
    }
    if (hasPunc) {
        return ans + punc;
    }
    return ans;
  }


  

    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCS = ".,:;!?";


    /*=====================================
      boolean isPunc(String) -- tells whether a character is punctuation
      pre:  symbol.length() == 1
      post: isPunc(".") -> true
            isPunc("b") -> false
      =====================================*/
    public static boolean isPunc( String symbol ) {
	    return PUNCS.indexOf( symbol ) != -1;
    }


    /*=====================================
      boolean isUpperCase(String) -- tells whether a letter is uppercase
      pre:  letter.length() == 1
      post: isUpperCase("a") -> false
            isUpperCase("A") -> true
      =====================================*/
    public static boolean isUpperCase( String letter ) {
      return CAPS.indexOf( letter ) != -1;
    }


    /*=====================================
      boolean hasPunc(String) -- tells whether a String contains punctuation
      pre:  w != null
      post: hasPunc("cat.") -> true
            hasPunc("cat") -> false
      =====================================*/
    public static boolean hasPunc( String w ) {
      for (int i=0; i<w.length();i++){
        if (isPunc(w.substring(i,i+1))){
          return true;
  		  }
      }
      return false;
    }


    /*=====================================
      boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
      pre:  w != null and w.length() > 0
      post: beginsWithUpper("Apple") -> true
            beginsWithUpper("apple") -> false
      =====================================*/
    public static boolean beginsWithUpper( String w ) {
        return isUpperCase(w.substring(0,1) );
    }

    public static boolean hasUpper( String w ) {
        for (int i=0; i<w.length();i++){
            if (beginsWithUpper(w.substring(i,i+1))){
              return true;
            }
        }
        return false;
    }

/*
  public static void main(String [] args) {
    System.out.println(isPunc(".")); // -> true
    System.out.println(isPunc("b")); // -> false
    System.out.println(isUpperCase("a")); // -> false
    System.out.println(isUpperCase("A")); // -> true
    System.out.println(hasPunc("cat")); // -> false
    System.out.println(hasPunc("cat.")); // -> true
    System.out.println(beginsWithUpper("Apple")); // -> true
    System.out.println(beginsWithUpper("apple")); // -> false
  }
  
*/
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner( System.in );
        boolean quit = true;
        while (scanner.hasNext() && quit) {
            String input = scanner.next();
            if (input.equals("iwanttoquitthis")) {
                quit = false;
            }
            System.out.print(engToPig(input) + " ");
            
        }

        
        

    }
}//end class Pig
