// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW83: Stacks on Stacks
// 2022-03-29t
// time spent: 0.3 hrs

/***
 * class Latkes
 * v1
 * SKELETON
 * Implements a stack of Strings using an encapsulated array
 **/

/***
 * DISCO
 * We should expand the capacity of the stack when it is full
 * You can only add/remove from the top of the stack
 * QCC
 * pancakes!?
 **/

public class Latkes {
  private String[] _stack;
  private int _stackSize;

  // constructor
  public Latkes(int initCapacity) {
    /*
     * your
     * SIMPLE
     * SMART
     * magicks
     * here
     */
    _stack = new String[initCapacity];
    _stackSize = 0;
  }// O(?)

  // means of insertion
  public void push(String s) {
    if (isFull()) {
      String[] temp = new String[_stack.length * 2];
      for (int i = 0; i < _stack.length; i++) {
        temp[i] = _stack[i];
      }
      _stack = temp;
    }
    _stack[_stackSize] = s;
    _stackSize++;
  }// O(n)

  // means of removal
  public String pop() {
    if (isEmpty()) {
      return null;
    }
    String ret = _stack[_stackSize - 1];
    _stack[_stackSize - 1] = null;
    _stackSize--;
    return ret;
  }// O(1)

  // chk for emptiness
  public boolean isEmpty() {
    return _stackSize == 0;
  }// O(1)

  // chk for fullness
  public boolean isFull() {
    return _stack.length == _stackSize;
  }// O(1)

  // main method for testing
  public static void main(String[] args) {

    Latkes tastyStack = new Latkes(10);

    tastyStack.push("aoo");
    tastyStack.push("boo");
    tastyStack.push("coo");
    tastyStack.push("doo");
    tastyStack.push("eoo");
    tastyStack.push("foo");
    tastyStack.push("goo");
    tastyStack.push("hoo");
    tastyStack.push("ioo");
    tastyStack.push("joo");
    tastyStack.push("coocoo");
    tastyStack.push("cachoo");

    // cachoo
    System.out.println(tastyStack.pop());
    // coocoo
    System.out.println(tastyStack.pop());
    // joo
    System.out.println(tastyStack.pop());
    // ioo
    System.out.println(tastyStack.pop());
    // hoo
    System.out.println(tastyStack.pop());
    // goo
    System.out.println(tastyStack.pop());
    // foo
    System.out.println(tastyStack.pop());
    // eoo
    System.out.println(tastyStack.pop());
    // doo
    System.out.println(tastyStack.pop());
    // coo
    System.out.println(tastyStack.pop());
    // boo
    System.out.println(tastyStack.pop());
    // aoo
    System.out.println(tastyStack.pop());

    // stack empty by now; SOP(null)
    System.out.println(tastyStack.pop());
    /*
     * v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
     * ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^
     */

  }// end main()

}// end class Latkes
