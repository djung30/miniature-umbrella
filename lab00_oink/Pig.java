public class Pig
{


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
    return w.contains(letter);
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
    return hasA(VOWELS, letter);
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
    int counter=0;
    for (int i=0; i<w.length();i++){
      if (isAVowel(w.substring(i,i+1))){
        counter++;
      }
    }
    return counter;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
    for (int i=0; i<w.length();i++){
      if (isAVowel(w.substring(i,i+1))){
        return true;
  		}
    }
    return false;
  }

  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
    String output = "";
    for (int i=0; i<w.length();i++){
      if (isAVowel(w.substring(i,i+1))){
        output = output + w.substring(i,i+1);
  		}
    }
    return output;                        
  }

    private static final String VOWELS = "aeiouy";
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
      post: hasPunc(“cat.”) -> true
            hasPunc(“cat”) -> false
      =====================================*/
    public static boolean hasPunc( String w ) {
      for (int i=0; i<w.length();i++){
        if (isPunc(w.substring(i,i+1))){
          return true;
  		  }
      }
      return false
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

}//end class Pig