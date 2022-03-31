// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW85: Leon Leonwood Stack
// 2022-03-30w
// time spent: 0.3 hrs

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {
    private LinkedList<PANCAKE> stack = new LinkedList<PANCAKE>();

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public PANCAKE peekTop() {
        return stack.get(stack.size() - 1);
    }

    public void push(PANCAKE pancake) {
        stack.add(pancake);
    }

    public PANCAKE pop() {
        PANCAKE ret = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return ret;
    }

    public String toString() {
        return stack.toString();
    }
}
