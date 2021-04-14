package com.company.offer;

import java.util.Stack;

public class ValidateStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int curPopedIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek().equals(popped[curPopedIndex++])) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
