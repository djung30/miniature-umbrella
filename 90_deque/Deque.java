//A Dog's Dream: Abdullah Faruque, David Chen, Daniel Jung
//APCS pd08
//HW90 - Swabbing the Deque
//2022-04-13W
//time spent: 0.5 hours

public interface Deque<T> {

    public boolean add(T x);  

    public void addFirst(T x);

    public void addLast(T x);  

    public T peek();

    public T peekFirst();

    public T peekLast();

    public boolean isEmpty();
    
    public T remove();

    public T removeFirst();

    public T removeLast();    

    public int size();
}
