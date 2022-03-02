/*
Radical Caticals: Anjini Katari, Ziying Jian, Daniel Jung
APCS
HW65 -- NQueens
2022-02-17
time spent: 1.5h
*/

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size ) 
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition: 
   * If a solution is found, board shows position of N queens, 
   * returns true.
   * If no solution, board is filled with 0's, 
   * returns false.
   */
  public boolean solve()
  {
    return solveH(0);
  }


  /**
   *Helper method for solve. 
   given the column, check if you can have a queen given the row
   purpose -> fill the board with queens     
   */
  private boolean solveH( int col ) 
  {
    if (col >= _board.length){
      return true;
    }
    for (int row = 0; row < _board.length; row ++){ //increment rows 
      if (addQueen(row, col) == true){ //
        if (solveH(col + 1) == true){
          return true;
        }
      }
      else{
        removeQueen(row, col);
      }
    }  
    return false;
  }


  public void printSolution()
  {
      String s = "";
      for (int i = 0; i < _board.length; i ++){ //rows
        for (int j = 0; j < _board[0].length; j ++){
            if (_board[i][j] <= 0){
                s += "_" + "\t";
            }
            else{
                s += "Q" + "\t";;
            }
        }
        s += "\n";
      }
      System.out.println(s);
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * add a queen and block out any spot where a queen is impossible 
   * precondition: array cannot have a size of 0
   * postcondition: selected square is populated 
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){ //if theres a 1(queen there)/-1(cant have a queen) you cant add a queen
      return false;
    }
    _board[row][col] = 1; //otherwise, add a queen
    int offset = 1; 
    while(col+offset < _board[row].length){ //while the next column isnt the last one 
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * removes queen and undos any blocked sections 
   * precondition: array cannot have a size of 0
   * postcondition: selected square is not a queen
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * prints the array
   * precondition: n/a
   * postcondition: a string with the array is printed
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    
    b.solve();
    System.out.println("solved");
    System.out.println("printSol");

    b.printSolution();
    System.out.println("toString");
    b.toString();

    QueenBoard two = new QueenBoard(2);
    two.solve();
    System.out.println("solved");
    System.out.println("printSol");

    two.printSolution();
    System.out.println("toString");
    two.toString();

    QueenBoard nada = new QueenBoard(0);
    nada.solve();
    System.out.println("solved");
    System.out.println("printSol");

    nada.printSolution();
    System.out.println("toString");
    nada.toString();



    /*
    System.out.println(b);
     should be...
       0	0	0	0	0	
       0	0	0	0	0	
       0	0	0	0	0	
       0	0	0	0	0	
       0	0	0	0	0	
    
    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    /** should be...
       0	1	-1	-2	-1	
       0	0	-2	0	0	
       0	-1	0	-1	0	
       1	-1	-1	-1	-2	
       0	-1	0	0	0	
    
    b.removeQueen(3,0);
    System.out.println(b);
    /** should be...
       0	1	-1	-1	-1	
       0	0	-1	0	0	
       0	0	0	-1	0	
       0	0	0	0	-1	
       0	0	0	0	0	 
    */
    
  }

}//end class
