package com.company.offer;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    /** initialize your data structure here. */
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
        if (stackB.isEmpty()) {
            stackB.push(x);
        } else {
            if (stackB.peek() >= x) stackB.push(x);
            else stackB.push(stackB.peek());
        }
    }

    public void pop() {
        if (!stackA.isEmpty()) {
            stackA.pop();
            stackB.pop();
        }
    }

    public int top() {
        if (!stackA.isEmpty())
            return stackA.peek();
        else return -1;
    }

    public int min() {
        if (stackB.isEmpty()) return -1;
        return stackB.peek();
    }
}
