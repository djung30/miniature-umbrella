
// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW75: Nodal Recall
// 2022-03-13s
// time spent: 0.5 hrs

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String _cargo;
  private LLNode _nextNode;

  // constructor
  public LLNode( String value, LLNode next )
  {
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _cargo;
  }

  public LLNode getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    String result = "[" + this._cargo;
    LLNode tmp = this._nextNode;
    while (tmp != null) {
        result += ", " + tmp.getCargo();
        tmp = tmp.getNext();
    }
    result += "]";
    return result;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );

    LLNode current = first;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    /* A naive list traversal, has side effects.... ??
       while( first != null ) {
         System.out.println( first );
         first = first.getNext();
       }
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: garbage collector reclaims that memory

    //  so, better: (w/o moving first)
    /*
      LLNode temp = first;
      while( temp != null ) {
        System.out.println( temp );
        temp = temp.getNext();
      }
    */

  }//end main

}//end class LLNode
