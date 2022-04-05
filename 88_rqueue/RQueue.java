// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faruque)
// APCS pd8
// HW87: The English Do Not Wait In Line for Soup
// 2022-04-3s
// time spent: 0.5 hrs

/*
DISCO: Queue shuffling is similar to the process of shuffling a deck of cards.

QCC: Should we modify the queue directly or create a new queue?
*/

/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 * -------------------------------
 * end | ---> Q U E U E ---> | front
 * -------------------------------
 *
 * linkages point opposite direction for O(1) en/dequeuing
 * N <- N <- ... <- N <- N
 * _end -^ ^- _front
 *
 **/

public class RQueue<T> implements Queue<T> {
    // instance variables
    private LLNode<T> _front, _end;
    private int _size;

    // default constructor creates an empty queue
    public RQueue() {
        _size = 0;
        _front = _end = null;
    }

    public void enqueue(T enQVal) {
        if (isEmpty()) {
            _front = _end = new LLNode<T>(enQVal, null);
        } else {
            _end.setNext(new LLNode<T>(enQVal, null));
            _end = _end.getNext();
        }
        _size++;
        // System.out.println("enqueue " + enQVal);
    }// O(1)

    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() {
        T retVal = _front.getCargo();
        _front = _front.getNext();

        if (_front == null) // just moved past last node
            _end = null; // update _end to reflect emptiness

        _size--;

        if (_size > 1) {
            sample();
        }

        return retVal;
    }// O(?)

    public T peekFront() {
        return _front.getCargo();
    }// O(?)

    /***
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * We can first generate a random number between 0 and _size - 1.
     * Then, we can traverse the queue from the front to the random number.
     * We can then enqueue the front node to the back of the queue.
     * We do this for `random` number of times.
     **/
    public void sample() {
        int random = (int) (Math.random() * _size);
        for (int i = 0; i < random; i++) {
            enqueue(dequeue());
        }
    }// O(n)

    public boolean isEmpty() {
        return _front == null;
    } // O(1)

    // print each node, separated by spaces
    public String toString() {
        String retStr = "FRONT :: ";
        LLNode<T> tmp = _front; // init tr
        while (tmp != null) {
            retStr += tmp.getCargo() + " ";
            tmp = tmp.getNext();
        }
        retStr += " :: END";
        return retStr;
    }// end toString()

    // main method for testing
    public static void main(String[] args) {

        Queue<String> PirateQueue = new RQueue<String>();
        System.out.println("\nnow enqueuing...");
        PirateQueue.enqueue("Dread");
        PirateQueue.enqueue("Pirate");
        PirateQueue.enqueue("Roberts");
        PirateQueue.enqueue("Blackbeard");
        PirateQueue.enqueue("Peter");
        PirateQueue.enqueue("Stuyvesant");
        System.out.println("\nnow testing toString()...");
        System.out.println(PirateQueue); // for testing toString()...
        System.out.println("\nnow dequeuing...");
        System.out.println(PirateQueue.dequeue());
        System.out.println(PirateQueue.dequeue());
        System.out.println(PirateQueue.dequeue());
        System.out.println(PirateQueue.dequeue());
        System.out.println(PirateQueue.dequeue());
        System.out.println(PirateQueue.dequeue());
        System.out.println("\nnow dequeuing fr empty queue...\n" +
                "(expect NPE)\n");
        System.out.println(PirateQueue.dequeue());
        /*
         * v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
         * ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^
         */

    }// end main

}// end class RQueues