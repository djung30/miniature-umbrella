// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faruque)
// APCS pd8
// HW103: Erica's Friends, Hugo, and The One in the Middle
// 2022-05-18
// time spent: 0.9 hrs

/*
DISCO: LAGGGGGGG

QCC: LAGGGGG? Does this mean that our program is inefficient? How can we improve the design? 
*/

// algo: 
// 1. If the next value is less than the root of maxHeap, add the value to maxheap, else add to minHeap.
// 2. If the difference in the size of the heaps is 2 or greater, you need to balance the heap by removing 
// from the larger heap and adding that value to the smaller heap (-this can be accomplished as the remove() 
// method retuurns the value removed)
// 3. find med by: 
// a. if heap sizes equal: med is mean of roots
// b. if heap sizes !equal: med is the root of larger heap

public class RunMed {
    
    ALHeapMin bigVals; 
    ALHeapMax lilVals;

    public RunMed() {
        
        ALHeapMin bigVals = new ALHeapMin(); 
        ALHeapMax lilVals = new ALHeapMax(); 

    }

    public int getMedian() {
        
        if (bigVals.getSize() == lilVals.getSize()) {
            return (bigVals.peekMin() + lilVals.peekMin()) / 2;
        } else {
            if (bigVals.getSize() > lilVals.getSize()) {
                return bigVals.peekMin();
            }
            return lilVals.peekMin();
        }

    }

    public void add(Integer newVal) {
        
        if (newVal < lilVals.peekMin()) {
            lilVals.add(newVal);
        } else {
            bigVals.add(newVal);
        }

        while (bigVals.getSize() - lilVals.getSize() > 1) {
            lilVals.add(bigVals.removeMin());
        }

        while (lilVals.getSize() - bigVals.getSize() > 1) {
            bigVals.add(lilVals.removeMin());
        }

    }
}
