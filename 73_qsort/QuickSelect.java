// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW73: All About the About Face
// 2022-03-08
// time spent: 1.1 hrs

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr1 = {1, 7, 3, 12, 5};
        System.out.println(ythSmallest(arr1, 1));
        System.out.println(ythSmallest(arr1, 4));
    }

    public static void swap(int x, int y, int[] o) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    // print input array
    public static void printArr(int[] a) {
        for (int o : a)
            System.out.print(o + " ");
        System.out.println();
    }

    // shuffle elements of input array
    public static void shuffle(int[] d) {
        int tmp;
        int swapPos;
        for (int i = 0; i < d.length; i++) {
            tmp = d[i];
            swapPos = i + (int) ((d.length - i) * Math.random());
            swap(i, swapPos, d);
        }
    }


    public static int partition( int arr[], int loPos, int hiPos, int pvtIndex)
    {
      int v = arr[pvtIndex];

      swap( pvtIndex, hiPos, arr);
      int s = loPos;

      for( int i = loPos; i < hiPos; i++ ) {
        if ( arr[i] <= v ) {
          swap( i, s, arr );
          s++;
        }
      }
      swap(s,hiPos,arr);

      return s;
    }//end partition


    public static int ythSmallestHelper(int[] arr, int start, int end, int y) {
      // 1 element array
      if (start == end) {
        return arr[start];
      }
      // partition array
      int pos = partition(arr, start, end, y-1);

      // pvtIndex == to pos of y
      if (pos == y - 1) {
        return arr[pos];
      }

      //
      if (pos > y - 1) {
          return ythSmallestHelper(arr, start, pos, y);
      }

      return ythSmallestHelper(arr, pos + 1, end, y);
    }

    public static int ythSmallest(int[] arr, int y) {
        return ythSmallestHelper(arr, 0, arr.length - 1, y);
    }
}
