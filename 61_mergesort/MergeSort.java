/***
  class MergeSort
  Implements mergesort on array of ints.
1. Compare the first elements in each array
2. Add the lowest element in the new array
3. Remove the element you added from its original array
4. Rinse and repeast till 1 array is empty
5. Add the remaining elements into the end of the merged array 
  ***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
  	int alen = a.length;
  	int blen = b.length;
    int aInd = 0;
    int bInd = 0;
    int mergeInd = 0;

  	int[] merged = new int[alen + blen];

  	while (mergeInd < merged.length && aInd < alen && bInd < blen) {
        if(a[aInd] < b[bInd]){
          merged[mergeInd] = a[aInd];
          aInd ++;
          mergeInd ++;
        }
       else {
          merged[mergeInd] = b[bInd];
          bInd ++;
          mergeInd ++;
        }
  }

    if (aInd == alen){
      for (int i = bInd; i < blen; i ++){
        merged[mergeInd] = b[i];
        mergeInd ++;
        bInd ++;
      }
    }

    else if (bInd == blen){
      for (int i = aInd; i < alen; i ++){
        merged[mergeInd] = a[i];
        mergeInd ++;
        aInd ++;
        bInd ++;
      }
    }
    return merged;
  	
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr)
  {
    int arrLen1 = (int) (arr.length / 2);
    int arrLen2 = arr.length - arrLen1;

    int[] arr1 = new int[arrLen1];
    int[] arr2 = new int[arrLen2];
    int iNdEx1 = 0;
    int iNdEx2 = 0;

    if (arr.length == 1){
      return arr;
    }

    else {
      for (int ind1 = 0; ind1 < arrLen1 ; ind1 ++){
        arr1[iNdEx1] = arr[ind1];
        iNdEx1 ++; 
  
        }
        for (int ind2 = arrLen1; ind2 < arr.length ; ind2 ++){
          arr2[iNdEx2] = arr[ind2];
          iNdEx2 ++; 
        }
        return merge(sort(arr1), sort(arr2));
      }
  }



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  // mess keeps the array length and sets all values to 0, creating chaos and confusion 
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      int[] arr8 = {0, 9, 17, 23, 42, 63, 512};


      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nMerging arr4 and arr8: ");
      printArray( merge(arr4,arr8) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );

      printArray( sort( arr5 ) ); 

      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );

  }//end main()

}//end class MergeSort
