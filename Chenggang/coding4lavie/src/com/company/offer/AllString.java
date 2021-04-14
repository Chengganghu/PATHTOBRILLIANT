package com.company.offer;

import com.company.CreateTree;
import com.company.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AllString {
    public static List<String> list = new ArrayList<>();
    public static List<String> allString(String input) {
        backTrack(input.toCharArray(), 0, input.length() -1 );
        return list;
    }

    public static void backTrack (char[] array, int start, int end) {
        if (start == end) {
            list.add(new String(array));
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(array[i])) continue;;
            set.add(array[i]);
            swap(array, start, i);
            backTrack(array, start +1, end);
            swap(array, start, i);
        }
    }

    public static void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
//        allString("good");
//        for (String s : list) {
//            System.out.println(s);
//        }
        TreeNode root = CreateTree.create();
        pathSum(root, 15);
    }

    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    static void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
