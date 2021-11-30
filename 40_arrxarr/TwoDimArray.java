/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

/***
 * Walrus (Humans: Daniel Jung, Joshua Yagupsky, Ethan Lam; Ducks: Ralph, Quacker, Carl)
 * APCS
 * HW40 -- 2D arrays
 * 2021-11-30
 * time spent: 0.5hrs
 * QCC:

 * Disco:
    - The length of a 2D array is the number of rows. To get the length of row r, just do array[r].length
    - RC COLA - Rows, Columns
 		- array.length has NO PARANTHESES
 ***/

public class TwoDimArray
{
  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a ){
    for(int i = 0; i < a.length; i++){
      for(int j = 0; j < a[i].length; j++){
        System.out.print(" ");
        System.out.print(a[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a ){
    for(int[] b : a){
  		for(int c: b){
        System.out.print(" ");
  			System.out.print(c);
  		}
      System.out.println();
  	}
    System.out.println();
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a )
  {
    int sum = 0;
    for(int[] b : a){
      for(int c: b){
        sum += c;
      }
    }
    return sum;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow
  public static int sum2( int [][] m )
  {
    int sum = 0;
    for(int r = 0; r < m.length; r++){
      sum += sumRow(r,m);
    }
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a )
  {
    int sum = 0;
    for(int c = 0; c<a[r].length; c++){
      sum += a[r][c]; //Remember, RC Cola!
    }
    return sum;
  }

  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m)
  {
    // *** YOUR IMPLEMENTATION HERE ***
    int summer = 0;
    for (int e : m[r]) {
      summer += e;
    }
    return summer;
  }


  public static void main( String [] args )
  {

      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };
      print1(m1);
      print1(m2);
      print1(m3);
      print2(m1);
      print2(m2);
      print2(m3);
      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1));
      System.out.println("sum m2 : " + sum1(m2));
      System.out.println("sum m3 : " + sum1(m3));
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));

    // your own custom test cases welcomed and encouraged
  }

}//end class TwoDimArray
