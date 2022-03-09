// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW72: So So Fast
// 2022-03-08
// time spent: 1.1 hrs
/*
Algo:
    Initialize lo and hi to 0 and n-1, respectively.
    Let pvtIndex be the value returned by partition(arr, lo, hi, lo).
    while pvtIndex != k, check if pvtIndex is less than k. if true, set lo to pvtIndex + 1 (increasing the lower bound)
    otherwise, return arr[k - 1] because we know the first `pvtIndex` elements are sorted. Then partition (arr, lo, hi, lo). When pvtIndex = k, return arr[pvtIndex - 1].
Best Case: 
		The Best Case would be when the yth smallest value in the array is in the first position and its classification would be O(n). 
Worst Case: 
		The Worst Case would be when the yth smallest value in the array is in the last position and its classification would be 0(n^2). 
DISCOS:
		There is no need to change hi.
QCC:
		Is there a way to improve/optimize our code/algo? 
*/


public class FastSelect { 
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
      
    //return int array of size s, with each element fr range [0,maxVal]
    public static int[] buildArray( int s, int maxVal )
    {
      int[] retArr = new int[s];
      for( int i = 0; i < retArr.length; i++ )
        retArr[i] = (int)( maxVal * Math.random() );
      return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------
  
  
    /**
     * int partition(int[],int,int,int)
     * Change array so that each element from lo to hi < arr[partIndex] is on the left 
     * and elements >= arr[partIndex] is on the right.
     * 
     * @param arr
     * @param lo | lower bound
     * @param hi | upper bound
     * @param partIndex | index of value to form partition
     * @return int 
     *
     */
    public static int partition( int arr[], int lo, int hi, int pvtIndex)
    {
      int partition = arr[pvtIndex];
  
      swap(pvtIndex, hi, arr);
  
      int swapIndex = lo;
      for (int i = lo; i < hi - 1; i++) {
        if (arr[i] < partition) {
          swap(swapIndex, i, arr);
          swapIndex++;
        }
      }
      swap(hi, swapIndex, arr);
  
  
      return swapIndex;
    }//end partition

    
    public static int fastSelect(int[] arr, int k) {
        int lo = 0;
        int hi = arr.length - 1;
        int pvtIndex = partition(arr, lo, hi, lo);

        while (pvtIndex != k) {
            if (pvtIndex < k) {
                lo = pvtIndex + 1;
            } else {
                return arr[k - 1];
            }
            pvtIndex = partition(arr, lo, hi, lo);
        }
        return arr[pvtIndex - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {7,21,17,69,343};
        int[] arr3 = {1,28,33,4982,37};
        int[] arr4 = {5,4,17,9000,6};
        int[] arr5 = {3,0,16,599,1024};
        int[] arr6 = {21, 17, 69, 343, 7, 23, 1223};
        int[] bestCase = {21,7,17,69,343};
        int[] worstCase = {7,17,69,343,21};

        System.out.println(fastSelect(arr1, 3)); // 21
        System.out.println(fastSelect(arr3, 3)); // 33
        System.out.println(fastSelect(arr4, 3)); // 6
        System.out.println(fastSelect(arr5, 3)); // 16
        System.out.println(fastSelect(arr6, 3)); // 21
        System.out.println(fastSelect(bestCase, 3)); // 21
				System.out.println(fastSelect(worstCase, 3)); // 21
    }
}
