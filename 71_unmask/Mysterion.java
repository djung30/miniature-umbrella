// Radical Caticals -- Ziying Jian, Daniel Jung, Anjini Kateri
// APCS pd08
// HW71 -- Reading for intent, tracing for VICTORY
// 2022-03-07
// time spent:  hrs

/***
 * SKEELTON for
 * class unmaskSort
 * tests preliminary hypotheses re: utility of mystery algo
 *
 * <h1>It's a Bird, It's a Plane! It's.... unmaskSort</h1>
 * The unmaskSort method ... <YOUR TRIO'S DESCRIPTION HERE>
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Trey Parker, Matt Stone
 * @version 3.1415926535897932384626433
 * @since   2022-03-07m
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s]
 *
 * DISCO
 * Though it may not be evident at first, each variable serves a purpose in the sort
 * Tracing is really useful! And we learned a new way to set it up in an efficient way
 *
 * QCC
 * How is this alogrithim used? Is this even a sort?
 * What are we missing from this alogrithim to make it complete?
 * Who came up with this?
 *
 * q0: What does it do?
 * a0: The user takes a segment of the array by specifying the start and end indices.
 * The uer also sets a value in the array that is not the start or end value, and the algo sorts
 * the elements according to if they are greater or less than this said value.
 *
 * q1: O(?)
 * a1: The function is O(n) because there is only one for loop.
 ***/


public class Mysterion
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------

/*
* a: The starting index of the segment of the array
* b: The ending index of the segment of the array
* c: The index of the value used for the algo
* s: The number of swaps
* v: The value of the chosen index
*/
  public static int[] unmaskSort( int[] arr, int startIndex, int endIndex, int c)
  {
	   int v = arr[c];
     swap(c, endIndex, arr);
     int start = startIndex;
     for (int index = 0; index < endIndex-1; index++){
       if (arr[index] < v) {
         swap(start, index, arr);
         start++;
       }
     }
     swap(endIndex, start, arr);
     return arr;
  }//end unmaskSort


  //main method for testing
  public static void main( String[] args )
  {
    //init test arrays of magic numbers
    int[] arr0 = {7,1,5,12,3};
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};

    // run unmaskSort on each array,
    // holding a & b fixed, varying c...
    for( int testC = 0; testC < 5; testC++ ) {
    System.out.println("arr0: ");
    printArr(arr0);
    unmaskSort(arr0,0,4,testC);
    System.out.println("after unmaskSort w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr0);
    System.out.println("-----------------------");

    System.out.println("arr1: ");
    printArr(arr1);
    unmaskSort(arr1,0,4,testC);
    System.out.println("after unmaskSort w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr1);
    System.out.println("-----------------------");

    System.out.println("arr3:");
    printArr(arr3);
    unmaskSort(arr3,0,4,testC);
    System.out.println("after unmaskSort w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr3);
    System.out.println("-----------------------");

    System.out.println("arr4:");
    printArr(arr4);
    unmaskSort(arr4,0,4,testC);
    System.out.println("after unmaskSort w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr4);
    System.out.println("-----------------------");

    System.out.println("arr5:");
    printArr(arr5);
    unmaskSort(arr5,0,4,testC);
    System.out.println("after unmaskSort w/ a=0,b=4,c="
    + testC +"...");
    printArr(arr5);
    System.out.println("-----------------------");
  } // end for loop
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main

}//end class unmaskSort
