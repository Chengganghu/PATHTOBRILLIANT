package com.company;

import java.util.Stack;

public class ReverseList {

    public static ListNode reverseList(ListNode input) {
        if (input == null || input.next == null) {
            return input;
        }
        ListNode curNode = input.next;
        ListNode output = reverseList(input.next);
        curNode.next = input;
        input.next = null;
        return output;
    }

}
