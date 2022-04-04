// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faruque)
// APCS pd8
// HW87: The English Do Not Wait In Line for Soup
// 2022-04-3s
// time spent: 0.5 hrs
/**
 * DISCO:
 * - We can use a class inside a class to make a Node
 * QCC:
 * N/A
 */

public class NodeQueue<QUASAR> implements Queue<QUASAR> {

    private class Node {
        private QUASAR cargo;
        private Node next;

        public Node(QUASAR cargo, Node next) {
            this.cargo = cargo;
            this.next = next;
        }
    }

    private Node _head;
    private int _size;

    public NodeQueue() {
        _head = new Node(null, null);
        _size = 0;
    }

    public void enqueue(QUASAR cargo) {
        if (_head == null) {
            _head = new Node(cargo, null);
        } else if (isEmpty()) {
            _head.cargo = cargo;
        } else {
            Node temp = _head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(cargo, null);
        }
        _size++;
    }

    public QUASAR dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            QUASAR temp = _head.cargo;
            _head = _head.next;
            _size--;
            return temp;
        }
    }

    public QUASAR peekFront() {
        if (isEmpty()) {
            return null;
        } else {
            return _head.cargo;
        }
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public static void main(String[] args) {
        Queue<String> q = new NodeQueue<String>();
        q.enqueue("Hello");
        q.enqueue("World");
        q.enqueue("!");

        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }

        q.enqueue("Hello");
        System.out.println(q.peekFront());
    }

}
