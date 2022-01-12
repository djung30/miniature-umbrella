/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW54 -- Sorting algos
 * 2022-1-11
 * time spent: 0.2hrs
 ***/

import java.util.ArrayList;

public class MySorts {

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

  // ALGO:
  // 1. Traverses through the array from right to left
  // 2. Compares two adjacent indexes at a time
  // 3. Swaps the adjacent elements if they are out of order
  // 4. Repeat until array is sorted
  public static void bubbleSort( ArrayList<Comparable> data )
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
  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  // ALGO:
  // 1. Find the maximum element of the unsorted part of the collection.
  // 2. Move this element to the end of the unsorted part of the collection.
  // 3. This element is now sorted. Repeat until you have a sorted collection.
  public static void selectionSort( ArrayList<Comparable> data )
  {
    //note: this version places greatest value at "rightmost" end

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos = 0;
    Comparable temp;
    for( int pass = data.size() - 1; pass > 0; pass--) {
      /*System.out.println( "\nbegin pass " + (data.size()-pass) );//diag*/
      for( int i = 0; i <= pass; i++ ) {
        if (data.get(i).compareTo(data.get(maxPos)) > 0) {
        	maxPos = i;
        }

        /*System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag*/
      }
      temp = data.remove(maxPos);
      data.add(pass, temp);
      /*System.out.println( "after swap: " +  data );//diag*/
      maxPos = 0;
    }
  }


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  // ALGO:
  // Walk each item to the right of the partition to its correct location in the sorted part of the array, then increment the partiion and repeat.
  public static void insertionSort( ArrayList<Comparable> data )
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
  }

}
