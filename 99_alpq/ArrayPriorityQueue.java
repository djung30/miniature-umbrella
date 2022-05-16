import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{
    
    private ArrayList<Integer> bruv = new ArrayList<Integer>();
    
    //O(1)
    public boolean isEmpty() {
        return bruv.isEmpty();
    }

    //O(1)
    public int peekMin() {
        return bruv.get(bruv.size()-1);
    }

    //O(1)
    public int removeMin() {
        return bruv.remove(bruv.size()-1);
    }

    //O(n)
    public void add(int value) {
        // add in order of priority
        for (int i = 0; i < bruv.size(); i++) {
            if (value < bruv.get(i)) {
                bruv.add(i, value);
                return;
            }
        }
        bruv.add(value);        
    }

    public static void main(String[] args) {
        ArrayPriorityQueue test = new ArrayPriorityQueue();
        test.add(5);
        test.add(10);
        test.add(4);
        test.add(3);
        test.add(29);
        test.add(2);



        System.out.println("min: " + test.peekMin());
        System.out.println("removing min: " + test.removeMin());
        System.out.println("min: " + test.peekMin());
        System.out.println("removing min: " + test.removeMin());

        System.out.println("min: " + test.peekMin());
        System.out.println("removing min: " + test.removeMin());
        System.out.println("min: " + test.peekMin());

        System.out.println("removing min: " + test.removeMin());
        System.out.println("min: " + test.peekMin());
        System.out.println("removing min: " + test.removeMin());
        System.out.println("min: " + test.peekMin());
        System.out.println("removing min: " + test.removeMin());
    }
}
