package com.company.sort;

import java.util.HashMap;
import java.util.Map;

public class QuickSort {

    public static void quickSort(int[] array, int start, int end) {
        if (start > end) return;
        int partitionIndex = partition(array, start, end);
        quickSort(array, start, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, end);
    }

    public static int partition(int[] array, int start, int end) {
        int base = array[end];
        while (start < end) {
            while(start < end && array[start] <= base){
                start++;
            }
            if (start < end) {
                swap(array, start, end);
                end--;
            }
            while (start < end && array[end] >= base) {
                end--;
            }
            if (start < end) {
                swap(array, start, end);
                start++;
            }
        }
        return start;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3,4,1,6,8,2,3,10,45,67,34,45,71,39,21,34,25,83,90,121,47,94,88,66,41,1,11,19,95};
        System.out.println("before sort:");
        for (int i: array) {
            System.out.print(i + "-->");
        }
        quickSort(array, 0, array.length - 1);

        System.out.println("\nafter sort");
        for (int i:array) {
            System.out.print(i + "-->");
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");


    }


}
