// Radical Caticals: Anjini Katari, Ziying Jian, Daniel Jung (Special Guest: Ruby Friedman)
// APCS pd08
// HW68 -- ...and T-, Tr-, Tri-, Tries Again Until It's Done (recursively probing for a closed cycle)
// 2022-03-2w
// time spent: 2.5 hrs

/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 * ALGO:
 *    Start in a given location
 *    If you can move to a sqaure that is populated with 0, move there;
 *    prioritizing the moves in this order:
 *    1 right, 2 down
 *    2 right, 1 up
 *    1 left, 2 up
 *    2 left, 1 down
 *    1 right, 2 up
 *    2 right, 1 down
 *    1 left, 2 down
 *    2 left, 1 up
 *    If none of these are possible, replace the square in question with 0,
 *    and backtrack to the last square, continuing down the chain of
 *    prioritization
 *
 * DISCO:
 * VS Code can cause glitches in the terminal
 * For populating the board with '-1', it was easier to use 2 for loops
 *  vs 1 for loop
 * You can slow down the program so you can watch how the program progresses
 *
 * QCC:
 * Is there a better way to optimize our code so that we can have a faster execution time.
 * What prioritization of moves is most optimal? Is it even possible to test?
 *
 * Mean execution times for boards of size n*n:
 * n=5   2.6878s   across 5 executions
 * n=6   __s    across __ executions
 * n=7   __s    across __ executions
 * n=8   __s    across __ executions
 * Attempted to run code for other n values, but took over 5 minutes and did not finish.
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }

    TourFinder tf = new TourFinder( n );

    //clear screen using ANSI control code
    System.out.println( "[2J" );

    //display board
    System.out.println( tf );

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:
    tf.findTour( 2, 2, 1 );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
    int startX = (int)(Math.random() * n);
    int startY = (int)(Math.random() * n);
    tf.findTour( startX, startY, 1 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;

  //constructor -- build board of size n x n
  public TourFinder( int n )
  {
    _sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int[_sideLength+4][_sideLength+4];


    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
    for (int i = 0; i < _sideLength+4; i++){
      _board[0][i] = -1;
      _board[1][i] = -1;
      _board[_sideLength + 2][i] = -1;
      _board[_sideLength + 3][i] = -1;
    }
    for (int i = 0; i < _sideLength+4; i++){
        _board[i][0] = -1;
        _board[i][1] = -1;
        _board[i][_sideLength + 2] = -1;
        _board[i][_sideLength + 3] = -1;
      }
    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
    //delay(50); //slow it down enough to be followable

    //if a tour has been completed, stop animation
    if ( _solved == true) System.exit(0);

    //primary base case: tour completed
    if (  moves == (_sideLength * _sideLength) + 1) {
      _solved = true;
      System.out.println( this ); //refresh screen
      return;
    }
    //other base case: stepped off board or onto visited cell
    if ( _board[x][y] != 0 ) {
      return;
    }
    //otherwise, mark current location
    //and recursively generate tour possibilities from current pos
    else {

      //mark current cell with current move number
      _board[x][y] = moves;

      System.out.println( this ); //refresh screen

      //delay(1000); //uncomment to slow down enough to view

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/
      findTour(x+1, y+2, moves +1);
      findTour(x+2, y-1, moves+1);
      findTour(x-1, y-2, moves+1);
      findTour(x-2, y+1, moves+1);
      findTour(x+1, y-2, moves +1);
      findTour(x+2, y+1, moves+1);
      findTour(x-1, y+2, moves+1);
      findTour(x-2, y-1, moves+1);


      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
        _board[x][y] = 0;

      System.out.println( this ); //refresh screen
    }
  }//end findTour()

}//end class TourFinder
