// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW78: Double Up
// 2022-03-17s
// time spent: 0.5 hrs

public class DLLNode {
    private String _cargo;
    private DLLNode _nextNode;
    private DLLNode _prevNode;

    public DLLNode(DLLNode prev, String value, DLLNode next) {
        this._cargo = value;
        this._nextNode = next;
        this._prevNode = prev;
    }

    public DLLNode() {}

    // --------------v ACCESSORS v--------------
    public String getCargo() {
        return this._cargo;
    }

    public DLLNode getNext() {
        return this._nextNode;
    }

    public DLLNode getPrev() {
        return this._prevNode;
    }
    // --------------^ ACCESSORS ^--------------

    // --------------v MUTATORS v--------------
    public String setCargo(String newCargo) {
        String foo = getCargo();
        _cargo = newCargo;
        return foo;
    }

    public DLLNode setNext(DLLNode newNext) {
        DLLNode foo = getNext();
        _nextNode = newNext;
        return foo;
    }

    public DLLNode setPrev( DLLNode newPrev )
     {
       DLLNode foo = getPrev();
       _prevNode = newPrev;
       return foo;
    }
     //--------------^  MUTATORS  ^--------------

    public String toString() {
        return _cargo.toString();
    }

    public static void main(String[] args) {
      DLLNode first = new DLLNode();
    }
}
