// A Dog's Dream (David Chen + Daniel Jung + Abdullah Faraque)
// APCS pd8
// HW85: Leon Leonwood Stack
// 2022-03-30w
// time spent: 0.3 hrs

import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {
    private ArrayList<PANCAKE> _stack;

    public ALStack() {
        _stack = new ArrayList<PANCAKE>();
    }

    public boolean isEmpty() {
        return _stack.size() == 0;
    }

    public PANCAKE peekTop() {
        if (isEmpty()) {
            return null;
        }
        return _stack.get(_stack.size() - 1);
    }

    public void push(PANCAKE pancake) {
        _stack.add(pancake);
    }

    public PANCAKE pop() {
        if (isEmpty()) {
            return null;
        }
        PANCAKE ret = _stack.get(_stack.size() - 1);
        _stack.remove(_stack.size() - 1);
        return ret;
    }

    public String toString() {
        return _stack.toString();
    }
}
