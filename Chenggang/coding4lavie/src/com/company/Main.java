package com.company;

public class Main {

    public static void main(String[] args) {
        // reverse list test
        ListNode head = createList();
        displayList(head);
        ListNode reversed = ReverseList.reverseList(head);
        displayList(reversed);
    }


    public static ListNode createList(){
        ListNode l4 = new ListNode("4",null);
        ListNode l3 = new ListNode("3", l4);
        ListNode l2 = new ListNode("2", l3);
        ListNode l1 = new ListNode("1", l2);
        return l1;
    }

    public static void displayList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
