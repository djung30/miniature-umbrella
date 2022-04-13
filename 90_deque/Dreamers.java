//A Dog's Dream: Abdullah Faruque, David Chen, Daniel Jung
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-13W
//time spent: 0.5 hours

import java.util.LinkedList;

public class Dreamers<T> implements Deque<T> {

    LinkedList<T> dreamer; 

    public Dreamers() {
        dreamer = new LinkedList<T>(); 
    }

    public boolean add(T x) {
        return dreamer.add(x);
    }

    public void addFirst(T x) {
        dreamer.addFirst(x);
    }

    public void addLast(T x) {
        dreamer.addLast(x); 
    }

    public T peek() {
        return dreamer.peek();
    }

    public T peekFirst() {
        return dreamer.peekFirst();
    }

    public T peekLast() {
        return dreamer.peekLast();
    }

    public boolean isEmpty() {
        return dreamer.size() == 0;
    }

    public T remove() {
        return dreamer.remove();
    }

    public T removeFirst() {
        return dreamer.removeFirst();
    }

    public T removeLast() {
        return dreamer.removeLast();
    }

    public int size() {
        return dreamer.size();
    }
}
