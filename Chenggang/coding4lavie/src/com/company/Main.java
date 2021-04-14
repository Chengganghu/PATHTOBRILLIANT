package com.company;

import com.company.offer.FindRepeatNum;

public class Main {

    public static void main(String[] args) {
        // reverse list test
        if (false) {
            ListNode head = createList();
            displayList(head);
            ListNode reversed = ReverseList.reverseList(head);
            displayList(reversed);
        }

        // find repeat number
        if (false) {
            int nums[] = {2, 3, 1, 0, 2, 5, 3};
            FindRepeatNum.findRepeatNum2(nums);
        }

        // traverse tree
        if (true) {
            TreeNode root = CreateTree.create();
            TraverseTree.zigzag(root);
        }

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
