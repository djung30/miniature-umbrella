// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW77: Insert|Remove
// 2022-03-15t
// time spent: 0.3 hrs

/***
    DISCO: Objects can refer to itself, effectively eliminating the need to make a new temp object.
    - - We need special cases for add operations at the first index
    QCC: Is it possible to have a constant time add operation?
    ALGO ADD:
    - If we are adding at index 0, we can just use add method to add to the front of the list
    - Otherwise, we can create an temp object for _head
    - Traverse the list until we reach the index we want to add to
    - Set the temp object's next to a new LLNode with the data we want to add and the next of the temp object
    - Increment the size of the list
    ALGO REM:
    - If the size is 1, we can just set _head to null
    - Otherwise, we can create a temp object for _head
    - Traverse the list until we reach the index we want to remove
    - Set the temp object's next to the next of the next of the temp object
         - This skips the node we want to remove
    - Decrement the size of the list
***/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List // your List interface must be in same dir
{

    // instance vars
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList() {
        _head = null; // at birth, a list has no elements
        _tail = null;
        _size = 0;
    }

    // --------------v List interface methods v--------------

    public boolean add(String newVal) {
        DLLNode tmp = new DLLNode(null, newVal, _head);
        if (_head != null) {
            _head.setPrev(tmp);
        }
        _head = tmp;
        if (_tail == null) {
            _tail = tmp;
        }
        _size++;
        return true;
    }

    public String get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        String retVal;
        DLLNode tmp = _head; // create alias to head

        // walk to desired node
        for (int i = 0; i < index; i++)
            tmp = tmp.getNext();

        // check target node's cargo hold
        retVal = tmp.getCargo();
        return retVal;
    }

    public String set(int index, String newVal) {

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        DLLNode tmp = _head; // create alias to head

        // walk to desired node
        for (int i = 0; i < index; i++)
            tmp = tmp.getNext();

        // store target node's cargo
        String oldVal = tmp.getCargo();

        // modify target node's cargo
        tmp.setCargo(newVal);

        return oldVal;
    }

    // return number of nodes in list
    public int size() {
        return _size;
    }

    // insert a node containing newVal at position index
    public void add(int index, String newVal) {

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        DLLNode newNode = new DLLNode(null, newVal, null);

        // if index==0, insert node before head node
        if (index == 0)
            add(newVal);
        else if (index == _size) {
          DLLNode tmp = new DLLNode(_head, newVal, null);
          if (_tail != null) {
            _tail.setNext(tmp);
          }
          _tail = tmp;
          if (_head == null ) {
            _head = tmp;
          }
          _size++;
        }
        else {
            DLLNode tmp = _head; // create alias to head

            // walk to node before desired node
            for (int i = 0; i < index - 1; i++)
                tmp = tmp.getNext();

            // insert new node
            newNode.setNext(tmp.getNext());
            newNode.setPrev(tmp);
            tmp.getNext().setPrev(newNode);
            tmp.setNext(newNode);

            // increment size attribute
            _size++;
        }
    }

    // remove node at pos index, return its cargo
    public String remove(int index) {

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        String retVal;
        DLLNode tmp = _head; // create alias to head

        // if index==0, remove head node
        if (index == 0) {
            // check target node's cargo hold
            retVal = _head.getCargo();

            // remove target node
            _head = _head.getNext();
        } else {
            // walk to node before desired node
            for (int i = 0; i < index - 1; i++)
                tmp = tmp.getNext();

            // check target node's cargo hold
            retVal = tmp.getNext().getCargo();

            // remove target node

            if (index != _size - 1) {
              tmp.getNext().getNext().setPrev(tmp);
            }
            tmp.setNext(tmp.getNext().getNext());
        }

        // decrement size attribute
        _size--;

        return retVal;
    }

    // --------------^ List interface methods ^--------------

    // override inherited toString
    public String toString() {
        String retStr = "HEAD->";
        DLLNode tmp = _head; // init tr
        while (tmp != null) {
            retStr += tmp.getCargo() + "->";
            tmp = tmp.getNext();
        }
        retStr += "NULL";
        return retStr;
    }

    // main method for testing
    public static void main(String[] args) {

        LList james = new LList();

        System.out.println(james);
        System.out.println("size: " + james.size());

        james.add("beat");
        System.out.println(james);
        System.out.println("size: " + james.size());

        james.add("a");
        System.out.println(james);
        System.out.println("size: " + james.size());

        james.add("need");
        System.out.println(james);
        System.out.println("size: " + james.size());

        james.add("I");
        System.out.println(james);
        System.out.println("size: " + james.size());

        System.out.println("2nd item is: " + james.get(1));

        System.out.println("...and now 2nd item is: " + james.set(1, "got"));
        System.out.println(james);

        james.add(0, "whut");
        System.out.println("...after add(0,whut): ");
        System.out.println(james);

        james.add(4, "phat");
        System.out.println("...after add(4,phat): ");
        System.out.println(james);

        System.out.println("...after remove last: "
                + james.remove(james._size - 1));
        System.out.println(james);

        System.out.println("...after remove(0): " + james.remove(0));
        System.out.println(james);

        System.out.println("...after remove(0): " + james.remove(0));
        System.out.println(james);

        System.out.println("...after remove(0): " + james.remove(0));
        System.out.println(james);
    }

}// end class LList
