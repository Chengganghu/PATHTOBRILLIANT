package com.company.offer;

import com.company.CreateTree;
import com.company.TreeNode;

public class LowestCommonAncestor {
    private static TreeNode ans = null;

    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p ,q);
        boolean right = dfs(root.right, p ,q);
        if (left && right) {
            ans = root;
        }
        else if (left && (root.left == p || root.left == q)) {
            ans = root.left;
        } else if (right  && (root.right == p || root.right == q)) {
            ans = root.right;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = CreateTree.create();
        lowestCommonAncestor(root, CreateTree.t4, CreateTree.t5);
        System.out.println(ans);
    }
}
