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

public class LLNode {
    // instance vars

    private String _cargo;
    private LLNode _next;

    // constructor
    public LLNode(String value, LLNode next) {
        this._cargo = value;
        this._next = next;                    
    }

    // --------------v ACCESSORS v--------------
    public String getCargo() {
        return this._cargo;
    }

    public LLNode getNext() {
        return this._next;
    }

    public int size() {
        if (this._next == null) {
            return 1;
        } else {
            return 1 + this._next.size();
        }
    }
    // --------------^ ACCESSORS ^--------------

    // --------------v MUTATORS v--------------
    public String setCargo(String newCargo) {
        String oldCargo = this._cargo;
        this._cargo = newCargo;
        return oldCargo;
    }

    public LLNode setNext(LLNode newNext) {
        LLNode oldNext = this._next;
        this._next = newNext;
        return oldNext;
    }

    public LLNode remove(LLNode target) {
        if (this._next == target) {
            this._next = this._next.getNext();
            return target;
        } else {
            this._next = this._next.remove(target);
            return this;
        }
    }
    // --------------^ MUTATORS ^--------------

    // override inherited toString
    public String toString() {
        String result = "[" + this._cargo;
        LLNode tmp = this._next;
        while (tmp != null) {
            result += ", " + tmp.getCargo();
            tmp = tmp.getNext();
        }
        result += "]";
        return result;
    }

    // main method for testing
    public static void main(String[] args) {

        // Below is an exercise in creating a linked list...

        // Create a node
        LLNode first = new LLNode("cat", null);

        // Create a new node after the first
        first.setNext(new LLNode("dog", null));

        // Create a third node after the second
        first.getNext().setNext(new LLNode("cow", null));

        /*
         * A naive list traversal, has side effects.... ??
         * while( first != null ) {
         * System.out.println( first );
         * first = first.getNext();
         * }
         */

        // Q: when head ptr moves to next node in list, what happens to the node it just
        // left?

        LLNode current = first;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
        System.out.println(first);
        System.out.println(first.getNext());
        System.out.println(first.getNext().getNext());
        System.out.println(first.size());
        // ...so better: ?
        //
        //
        //

    }// end main

}// end class LLNode
