//A Dog's Dream: Abdullah Faruque, David Chen, Daniel Jung
//APCS pd08
//HW102: Heap On Heapin' On
//2022-05-17
//time spent: 0.5 hours

/**
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 */

import java.util.ArrayList;

public class ALHeap
{

  //instance vars
  private ArrayList<Integer> _heap;

  /**
   * default constructor  ---  inits empty heap
   */
  public ALHeap()
  {
    _heap = new ArrayList<Integer>();
  }



  /**
   * toString()  ---  overrides inherited method
   * Returns either
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   */
  public String toString()
  {
    String output = "[";
    for (int i = 0; i < _heap.size(); i++) {
      output += _heap.get(i);
    }
    output += "]";
    return output;
  }//O(n)


  /**
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   */
  public boolean isEmpty()
  {
    return _heap.isEmpty();
  }//O(1)


  /**
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   */
  public Integer peekMin()
  {
    return _heap.get(0);
  }//O(1)


  /**
   * add(Integer)
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   * ALGO:
   * 1. Add the value to the next level of the heap, or the end of the ArrayList
   * 2. While the value has a parent and the parent is greater than the value, swap.
   */
  public void add( Integer addVal )
  {
    int position = _heap.size();
    _heap.add(addVal);
    while (((position-1)-2) >= 0 && _heap.get((position-1)/2) > _heap.get(position)) {
      swap(position, ((position-1)/2));
      position  = (position-1)/2;
    }
  }//O(log(n))


  /**
   * removeMin()  ---  means of removing an element from heap
   * Removes and returns least element in heap.
   * Postcondition: Tree maintains heap property.
   * ALGO:
   * 1. Take the last element in the ArrayList and swap it with the root. Remove (and store) the last element.
   * 2. Check if either of the chidlren of the current position (starts with root) are less than it, if so, swap with smallest child.
   */
  public Integer removeMin()
  {
    if (_heap.size() == 1) {
      return _heap.remove(0);
    } 
    else {
      int pos = 0;
      swap(0, _heap.size()-1);
      Integer returnVal = _heap.remove(_heap.size()-1);
      while ((2*pos+1 < _heap.size() && _heap.get(pos).compareTo(_heap.get(2*pos+1)) > 0) || (2*pos+2 < _heap.size() && _heap.get(pos).compareTo(_heap.get(2*pos+2)) > 0)) {
        int swapPos = minChildPos(pos);
        swap(pos, swapPos);
        pos = swapPos;
      }
  
      return returnVal;
    }
  }//O(log(n))


  /**
   * minChildPos(int)  ---  helper fxn for removeMin()
   * Returns index of least child, or
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   */
  private int minChildPos( int pos )
  {
    if (2*pos+1 > _heap.size()) {
      return -1;
    } else if (2*pos+2 > _heap.size()) {
      return 2*pos+1;
    } else {
      if (_heap.get(2*pos+1).compareTo(_heap.get(2*pos+2)) < 0) {
        return 2*pos+1;
      } else {
        return 2*pos+2;
      }
    }


  }//O(1)


  //~~~~~~~~~~~~~ aux helper fxns ~~~~~~~~~~~~~~
  private Integer minOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) < 0 )
      return a;
    else
      return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



  //main method for testing
  public static void main( String[] args )
  {
    
      ALHeap pile = new ALHeap();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMin() + "...");
      System.out.println(pile);
      
  }//end main()

}//end class ALHeap
