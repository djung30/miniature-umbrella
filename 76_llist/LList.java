// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW76: We Got a Little Ol' Convoy
// 2022-03-14
// time spent: 1.1 hrs

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = new LLNode(null, null);
    _size = size();
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    if (_head == null) {
      _head = new LLNode(newVal, null);;
    }
    else {
      LLNode tmp = _head;
      while (tmp.getNext() != null) {
        tmp = tmp.getNext();
      }
      tmp.setNext(new LLNode(newVal, null));
    }
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head;
    for (int i = 0; i < index; i++){
      tmp = tmp.getNext();
    }

    return tmp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode tmp = _head;
    for (int i = 0; i < index; i++){
      tmp = tmp.getNext();
    }

    return tmp.setCargo(newVal);
  }


  //return number of nodes in list
  public int size()
  {
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    String result = "[";
    LLNode tmp = _head;
    while (tmp != null) {
      result += tmp.getCargo() + ",";
      tmp = tmp.getNext();
    }
    result = result.substring(0,result.length()-1) + "]";
    return result;
  }


  //main method for testing
  public static void main( String[] args )
  {

    LList james = new LList();
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println( "2nd item is: " + james.get(1) );
    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );

  }

}//end class LList
