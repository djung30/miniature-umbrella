/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW51 -- BubbleSort
 * 2022-1-3
 * time spent: 0.3hrs
 ***/

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 * 1. Traverses through the array from right to left
 * 2. Compares two adjacent indexes at a time
 * 3. Swaps the adjacent elements if they are out of order
 * 4. Repeat until array is sorted
 * DISCO
 * To make a deep copy of an ArrayList, use the .clone() method.
 * Just note that you may have to typecast your result to something more general, i.e. instead of an ArrayList<Integer> you may want an ArrayList<Comparable>
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: It's sorted
 * q1: After pass p, what do you know?
 * a1: Index p-1 has the correct item
 * q2: How many passes are necessary to completely sort?
 * a2: It takes n-1 passes
 *
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    Comparable temp;
    //The outer loop is for completing n-1 passes
    for(int p = 0; p < data.size(); p++){
      //Here we traverse the array, but we speed things up by not having to modify elements we know are sorted.
      for (int i = data.size()-1; i > p; i--) {
        if(data.get(i).compareTo(data.get(i-1)) < 0){
          //Swap!
          temp = data.remove(i-1);
          data.add(i,temp);
        }
      }
    }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> result = (ArrayList<Comparable>) input.clone();
    bubbleSortV(result);
    return result;
  }


  public static void main( String [] args )
  {
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );


  }//end main

}//end class BubbleSort
