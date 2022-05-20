// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faruque)
// APCS pd8
// HW104 -- Heap Sort
// 2022-05-18
// time spent: 0.9 hrs
/****
 *
 * DISCO:
 * After removing the root, the last item of the array is in itsproper place
 * 
 * QCC:
 * what are the best and worst cases?
 *
 ****/

/**
 * class Heapsort
 * SKELETON
 * sorts in-place by heapifying data, then repeatedly pulling from heap
 */

public class Heapsort
{

  /**
   * int[] sort( int[] data )  --- returns sorted input array
   * Applies heapsort algorithm (in place)
   */
  public int[] sort( int[] data )
  {

    System.out.print( "Input array: \t" );
    printArr( data );


    //STEP 1: heapify array contents
    //slot 0 will contain root
    //(heap will grow from L to R)

    minHeapify(data);
    System.out.println( "Array heapified. Root at index 0" );
    printArr( data );


    //STEP 2: repeatedly pull from heap until empty
    //(Sorted region will grow from R to L)
    for( int lastLeaf = data.length - 1; lastLeaf > 0; lastLeaf--) {
      //set aside root val
      int tmp = data[0];

      //swap last leaf (rightmost on bottom level) into root pos
      swap(lastLeaf, 0, data);

      //walk now-out-of-place root node down the tree...
      int pos = 0;
      int minChildPos;
      int maxChildPos;

      while( pos < lastLeaf ) {

        //choose child w/ max value, or check for child
        //maxChildPos = maxChildPos(pos, lastLeaf, data);
	minChildPos = minChildPos(pos, lastLeaf - 1, data);

        //if no children, then i've walked far enough
        if ( minChildPos == -1 )
          break;
        //if i am greater than my greatest child, i've walked far enough
        else if ( data[pos] < data[minChildPos] )
          break;
        //if i am > least child, swap with that child
        else {
	  swap(minChildPos, pos, data);
          pos = minChildPos;
        }
      }

      //overwrite last leaf with old root val
      data[lastLeaf] = tmp;

    }


    //STEP teh LAST: return modified array
    return data;

  }//end sort() -- O(n log n)



  private void minHeapify( int[] a )
  {

    for( int i=1; i<a.length; i++ ) {
      //add a[i] as leaf
      int addValPos = i; //val to add is next non-heap element

      //now must percolate up
      while( addValPos > 0 ) { //potentially swap until reach root

        //pinpoint parent
        int parentPos = (addValPos - 1) / 2;

        if ( a[addValPos] < a[parentPos] ) {
          swap( addValPos, parentPos, a );
          addValPos = parentPos;
        }
        else
          break;
      }
    }
  }//end minHeapify() -- O(n log n)



  private void maxHeapify( int[] a )
  {

    for( int i=1; i<a.length; i++ ) {
      //add a[i] as leaf
      int addValPos = i; //val to add is next non-heap element

      //now must percolate up
      while( addValPos > 0 ) { //potentially swap until reach root

        //pinpoint parent
        int parentPos = (addValPos - 1) / 2;

        if ( a[addValPos] > a[parentPos] ) {
          swap( addValPos, parentPos, a );
          addValPos = parentPos;
        }
        else
          break;
      }
    }
  }//end maxHeapify() -- O(n log n)



  //return position of child with least value in input array
  private int minChildPos( int pos, int last, int[] a )
  {
    int retVal;
    int lc = 2*pos + 1; //index of left child
    int rc = 2*pos + 2; //index of right child

    //pos is not in the heap or pos is a leaf position
    if ( lc >= last )
      retVal = -1;
    //if no right child, then left child is only option for min
    else if ( rc > last )
      retVal = lc;
    //have 2 children, so compare to find least
    else if ( a[lc] < a[rc] )
      retVal = lc;
    else
      retVal = rc;

    return retVal;
  }//end minChildPos() -- O(1)



  //return position of child with greatest value in input array
  private int maxChildPos( int pos, int last, int[] a )
  {
    int retVal;
    int lc = 2*pos + 1; //index of left child
    int rc = 2*pos + 2; //index of right child

    //pos is not in the heap or pos is a leaf position
    if ( lc >= last )
      retVal = -1;
    //if no right child, then left child is only option for min
    else if ( rc > last )
      retVal = lc;
    //have 2 children, so compare to find max
    else if ( a[lc] > a[rc] )
      retVal = lc;
    else
      retVal = rc;

    return retVal;
  }//end maxChildPos() -- O(1)



  //--------------v- HELPER METHODS -v--------------
  private int minOf( int a, int b ) { return (a<b)?a:b; }

  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

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

  public static int[] buildArray( int size, int hi )
  {
    int[] retArr = new int[size];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( hi * Math.random() );
    return retArr;
  }
  //--------------^- HELPER METHODS -^--------------




  //main method for testing
  public static void main( String[] args )
  {
    int[] a = buildArray( 10, 10 );

    printArr(a);

    Heapsort h = new Heapsort();

    h.sort(a);

    printArr(a);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main()

}//end class