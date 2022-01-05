/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW53 -- Poker Face
 * 2022-1-5
 * time spent: 0.3hrs
 ***/

/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
 * Walk each item to the right of the partition to its correct location in the sorted part of the array, then increment the partiion and repeat.
 * DISCO
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n-1 passes
 * q1: What do you know after pass p?
 * a1: We know that the element previously at index p is now in the sorted partition
 * q2: How will you know when sorted?
 * a2: After n-1 passes
 * q3: What constitues a pass?
 * a3: Walking a single element into the sorted partiton
 * q4: What must you track?
 * a4: Where the partition is
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
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
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSortV( ArrayList<Comparable> data )
  {
    Comparable temp;
    for(int partition = 1; partition < data.size(); partition++) {
      //partition marks first item in unsorted region

      //System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
      //System.out.println( data );

      //traverse sorted region from right to left
      for(int prev = partition-1; prev >= 0; prev--) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if (data.get(prev).compareTo(data.get(prev+1)) > 0) {
          temp = data.remove(prev+1);
          data.add(prev,temp);
          //System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag

        }
        else
          break;
      }
    }
  }//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort


  public static void main( String [] args )
  {
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );
      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );


      System.out.println( "*** Testing non-void version... *** " );
      glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = insertionSort( glen );
      System.out.println( "\nsorted version of ArrayList glen:\n"
      + glenSorted );
      System.out.println( "\nArrayList glen after sorting:\n" + glen );
      coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = insertionSort( coco );
      System.out.println( "\nsorted version of ArrayList coco:\n"
      + cocoSorted );
      System.out.println( "\nArrayList coco after sorting:\n" + coco );
      System.out.println( coco );

  }//end main

}//end class InsertionSort
