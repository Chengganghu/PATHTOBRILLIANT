package com.company.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) return array;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, length/2));
        int[] right = mergeSort(Arrays.copyOfRange(array, length/2, length));
        return merge(left, right);
    }

    /**
     * 合并两个有序数组
     * @param left
     * @param right
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else {
                if (left[i] > right[j]) {
                    result[index] = right[j++];
                } else {
                    result[index] = left[i++];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3,4,1,6,8,2,3,10};
        int[] sorted = mergeSort(array);
        System.out.println("before sort:");
        for (int i: array) {
            System.out.print(i + "-->");
        }
        System.out.println("\nafter sort");
        for (int i:sorted) {
            System.out.print(i + "-->");
        }
    }
}
