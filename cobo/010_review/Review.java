import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();


  private static final String SPACE = " ";

  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }


  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }

  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }
  }

  /**
   * returns a string containing all of the text in fileName (including punctuation),
   * with words separated by a single space
   */
  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

public static double totalSentiment (String fileName){
  double value = 0.0;
  try {
  Scanner sentimentIn = new Scanner(new File (fileName));
  while (sentimentIn.hasNext()){
    value += sentimentVal(removePunctuation(sentimentIn.next()));
  } return value;
} catch (FileNotFoundException ex) {
  System.out.println("File not found.");
  return value;
}
}

public static int starRating (String fileName){
  double sentiment = totalSentiment(fileName);
  int rating = 0;
  if (sentiment < 5.0){
    rating = 1;
  } else if (sentiment < 10.0){
    rating = 2;
  } else if (sentiment < 15.0){
    rating = 3;
  } else if (sentiment < 20.0){
    rating = 4;
  } else if (sentiment < 25.0){
    rating = 5;
  }
  return rating;
}

public static String fakeReview(String filename){
  String Simple = textToString(filename);
  String[] arr = Simple.split(" ");
  String fin = "";

  for (int i = 0; i < arr.length; i ++){
    if (arr[i].startsWith("*")) {
      arr[i] = randomAdjective();
    }
    fin += arr[i];
    fin += " ";
  }
  return fin;
}

public static String extremeReview(String filename){
  String Simple = textToString(filename);
  String[] arr = Simple.split(" ");
  String fin = "";

  for (int i = 0; i < arr.length; i ++){
    if (arr[i].startsWith("*")) {
      if (sentimentVal(arr[i].substring(1)) < 0){
        arr[i] = randomPositiveAdj();
      }
      else {
        arr[i] = randomNegativeAdj();
      }
    }
    fin += arr[i];
    fin += " ";
  }
  return fin;
}

public static String shakespeareify(String stringeth){
  int len = stringeth.length();
  String shaketh = "";

  if (endsIn(stringeth) == true){ //end in vowel
    shaketh = stringeth;
    shaketh += "th";
  }
  else { //end in constenant
    shaketh = stringeth; 
    shaketh += "eth";
  }
  return shaketh;
}

public static boolean endsIn(String stringeth){
  boolean positive = Math.random() < .5;

  if (positive == true){
    return true;
  }
  else {
    return false;
  }
/*
* note: we aren't sure why this doesn't work...
  String lastOne = stringeth.substring(stringeth.length() - 1);
  System.out.println(lastOne);
  if (lastOne.equals("a")){
    return true;
  }
  else if (lastOne.equals("e") ) {
    return true;
  }
  else if (lastOne.equals("o") ) {
    return true;
  }
  else if (lastOne.equals("i") ) {
    return true;
  }
  else if (lastOne == "u" ) {
    return true;
  }
  else{
    return true;
  }
  */
}

/*
hello -> helloth 
meep -> meepeth 
are -> areth 
*/

public static void main(String [] args) {
  /*
    System.out.println(sentimentVal("backward"));
    System.out.println(sentimentVal("terrible"));
    System.out.println(sentimentVal("wonderful"));
    System.out.println("--------");
	  System.out.println(totalSentiment("SimpleReview.txt"));
    System.out.println("--------");
    System.out.println(starRating("SimpleReview.txt"));
    System.out.println("--------");
    System.out.println(fakeReview("SimpleReview.txt"));
    System.out.println("--------");
    System.out.println(extremeReview("SimpleReview.txt"));
    System.out.println("--------");
    */
    System.out.println(shakespeareify("meep"));
    System.out.println(shakespeareify("meepo"));

  }

}
