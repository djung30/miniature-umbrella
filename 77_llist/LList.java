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

public class LList implements List // interface def must be in this dir
{

    // instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList() {
        _head = null;
        _size = 0;
    }

    // --------------v List interface methods v--------------

    public boolean add(String newVal) {
        if (_head == null) {
            _head = new LLNode(newVal, null);
            ;
        } else {
            LLNode tmp = _head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new LLNode(newVal, null));
        }
        _size++;
        return true;
    }

    public String get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        LLNode tmp = _head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }

        return tmp.getCargo();
    }

    public String set(int index, String newVal) {

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        LLNode tmp = _head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }

        return tmp.setCargo(newVal);
    }

    // return number of nodes in list
    public int size() {
        return _size;
    }

    // --------------^ List interface methods ^--------------

    // override inherited toString
    public String toString() {
        String result = "[";
        LLNode tmp = _head;
        while (tmp != null) {
            result += tmp.getCargo() + ",";
            tmp = tmp.getNext();
        }
        result = result.substring(0, result.length() - 1) + "]";
        return result;
    }

    public void add (int index, String newval) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            _head = new LLNode(newval, _head);
        } else {
            LLNode tmp = _head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.getNext();
            }
            tmp.setNext(new LLNode(newval, tmp.getNext()));
            size++;
        }
    }

    public String remove(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        if (_size == 1) {
            String result = _head.getCargo();
            _head = null;
            _size--;
            return result;
        } else if (index == 0) {
            String result = _head.getCargo();
            _head = _head.getNext();
            _size--;
            return result;
        } else {
            LLNode tmp = _head;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.getNext();
            }
            String result = tmp.getNext().getCargo();
            tmp.setNext(tmp.getNext().getNext());
            _size--;
            return result;
        }
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
        james.set(1, "got");
        
        System.out.println("...and now 2nd item is: " + james.set(1, "got"));
        System.out.println(james);

    }

}// end class LList
