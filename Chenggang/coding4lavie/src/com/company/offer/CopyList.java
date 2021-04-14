package com.company.offer;

public class CopyList {

    public static Node copyRandomList(Node head) {
        Node current = head;
        while(current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        current = head;

        Node copied, copiedHead = head.next;
        while(current != null) {
            copied = current.next;
            copied.random = current.random == null ? null : current.random.next;
            current = copied.next;
        }
        current = head;
        while (current != null) {
            copied = current.next;
            current.next = copied.next;
            copied.next = copied.next == null ? null : copied.next.next;
            current = current.next;
        }
        return copiedHead;
    }
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        Node res = copyRandomList(n1);
    }
}
