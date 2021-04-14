package com.company.offer;

import java.util.Stack;

public class IsValide {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') stack.push(cur);
            else {
                if (!match(cur, stack.pop())) return false;
            }
        }
        return true;
    }

    public static boolean match(char c1, char c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}'))
            return true;
        return false;
    }

    public static void main(String[] args) {
        isValid("()");
    }
}
