// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faruque)
// APCS pd8
// HW89: Queue Two Ways
// 2022-04-12t
// time spent: 0.5 hrs

/*
DISCO: ALqueue and LLqueue are pretty similar in their methods. 

QCC: dog
*/

import java.util.LinkedList;

public class LLQueue<T> implements Queue<T> {
    LinkedList<T> _queue;

    public LLQueue() {
        _queue = new LinkedList<T>();
    }

    public void enqueue(T x) {
        _queue.add(x);
    }

    public T peekFront() {
        return _queue.get(0);
    }

    public T dequeue() {
        return _queue.remove(0);
    }

    public boolean isEmpty() {
        return _queue.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println("=======Testing Queue========");
        Queue<Integer> abdullah = new LLQueue<Integer>();
        abdullah.enqueue(1);
        abdullah.enqueue(23);
        abdullah.enqueue(23123);
        abdullah.enqueue(312312446);
        abdullah.enqueue(1123);
        abdullah.enqueue(11213);
        abdullah.enqueue(3231);
        abdullah.enqueue(2313);
        System.out.println(abdullah.isEmpty());
        System.out.println(abdullah.peekFront());

        while (!abdullah.isEmpty()) {
            System.out.println(abdullah.dequeue());
        }

        System.out.println(abdullah.isEmpty());

        Queue david = new LLQueue();
        david.enqueue(1);
        david.enqueue(23);
        david.enqueue(true);
        david.enqueue(new int[] { 1, 2, 3 });
        david.enqueue("sdasdas");
        david.enqueue("A Dog's Dream");
        System.out.println(david.peekFront());

        while (!david.isEmpty()) {
            System.out.println(david.dequeue());
        }

    }
}
