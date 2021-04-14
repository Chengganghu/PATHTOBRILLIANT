package com.company.offer;

import com.company.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inorderMapper = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMapper.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length, 0, preorder.length, inorderMapper);
    }


    private TreeNode buildTree(int[] preorder, int[] inorder, int inorderStart, int inorderEnd,
                               int preorderStart, int preorderEnd, Map<Integer, Integer> mapper) {
        int rootIndex = mapper.get(preorder[preorderStart]);
        int leftNodes = rootIndex - inorderStart; int rightNodes = inorderEnd - rootIndex;
        if (leftNodes == 0 && rightNodes == 0) {
            return new TreeNode(preorder[rootIndex]);
        }
        TreeNode root = new TreeNode(preorder[preorderStart]);
        TreeNode left = null, right = null;
        if (leftNodes != 0){
            left = buildTree(preorder, inorder, inorderStart, rootIndex -1,preorderStart + 1, preorderStart + leftNodes, mapper);
        }
        if (rightNodes != 0) {
            right = buildTree(preorder, inorder, rootIndex + 1, inorderEnd,preorderEnd - rightNodes + 1, preorderEnd, mapper);
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
