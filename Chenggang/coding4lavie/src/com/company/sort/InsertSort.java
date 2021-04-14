package com.company.sort;

public class InsertSort {

    public static void insertSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (array[j] < array[j - 1]){
                    swap(array, j, j-1);
                }
            }
        }
    }



    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3,4,1,6,8,2,3,10};
        System.out.println("before sort:");
        for (int i: array) {
            System.out.print(i + "-->");
        }
        insertSort(array);

        System.out.println("\nafter sort");
        for (int i:array) {
            System.out.print(i + "-->");
        }
    }
}
