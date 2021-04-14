package com.company;

import java.util.LinkedList;
import java.util.List;
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
                cur = stack.pop();
                if (cur != null) {
                    visit(cur);
                    stack.push(cur.right);
                    stack.push(cur.left);
                }
            }
        }
    }

    public static void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            visit(cur);
            if (cur != null) {
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }

    public static void depthOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()) {
            cur = stack.pop();
            if (cur != null) {
                visit(cur);
                stack.push(cur.right);
                stack.push(cur.left);
            }

        }
    }

    public static List<List<Integer>>zigzag(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        boolean leftToRight = false;

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode cur;
                if (!leftToRight) {
                    cur = queue.pollFirst();
                } else {
                    cur = queue.pollLast();
                }
                list.add(cur.val);
                if (!leftToRight) {
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                } else {
                    if (cur.right != null) queue.offer(cur.right);
                    if (cur.left != null) queue.offer(cur.left);
                }
            }
            leftToRight = !leftToRight;
            res.add(list);
        }
        return res;
    }


    public static void visit(TreeNode node) {
        System.out.println(node);
    }
}
