// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW78: Double Up
// 2022-03-17s
// time spent: 0.5 hrs

public class DLLNode<T> {
    private T _cargo;
    private DLLNode<T> _nextNode;
    private DLLNode<T> _prevNode;

    public DLLNode(DLLNode<T> prev, T value, DLLNode<T> next) {
        this._cargo = value;
        this._nextNode = next;
        this._prevNode = prev;
    }

    public DLLNode() {
    }

    // --------------v ACCESSORS v--------------
    public T getCargo() {
        return this._cargo;
    }

    public DLLNode<T> getNext() {
        return this._nextNode;
    }

    public DLLNode<T> getPrev() {
        return this._prevNode;
    }
    // --------------^ ACCESSORS ^--------------

    // --------------v MUTATORS v--------------
    public T setCargo(T newCargo) {
        T foo = getCargo();
        _cargo = newCargo;
        return foo;
    }

    public DLLNode<T> setNext(DLLNode<T> newNext) {
        DLLNode<T> foo = getNext();
        _nextNode = newNext;
        return foo;
    }

    public DLLNode<T> setPrev(DLLNode<T> newPrev) {
        DLLNode<T> foo = getPrev();
        _prevNode = newPrev;
        return foo;
    }
    // --------------^ MUTATORS ^--------------

    public String toString() {
        return _cargo.toString();
    }

    public static void main(String[] args) {
        DLLNode first = new DLLNode();
    }
}
