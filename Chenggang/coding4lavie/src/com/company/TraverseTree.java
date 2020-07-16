package com.company;

import java.util.Stack;

public class TraverseTree {

    public static void preOrderRecursion(TreeNode root) {
        if (root != null) {
            visit(root);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }


    public static void midOrderRecursion(TreeNode root) {
        if (root != null) {
            midOrderRecursion(root.left);
            visit(root);
            midOrderRecursion(root.right);
        }
    }

    public static void midOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            TreeNode cur = root;
            stack.push(root);
            while (!stack.isEmpty() || cur != null) {
                while (cur != null) {  // cur为空时，一种情况是找到最左端的节点了，另一种情况是上一次循环中，当前节点的右节点为空
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                visit(cur);
                cur = cur.right;
            }
        }

    }

    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            TreeNode cur = root;
            stack.push(cur);
            while (!stack.isEmpty()) {
                visit(cur);
                stack.push(cur.left);
                stack.push(cur.right);
            }
        }
    }


    public static void visit(TreeNode node) {
        System.out.println(node);
    }
}
