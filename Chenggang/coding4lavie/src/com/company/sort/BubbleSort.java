package com.company.sort;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3,4,1,6,8,2,3,10};
        int[] sorted = bubbleSort(array);
        System.out.println("before sort:");
        for (int i: array) {
            System.out.print(i + "-->");
        }
        System.out.println("\nafter sort");
        for (int i:sorted) {
            System.out.print(i + "-->");
        }

        System.out.println(sum(0, 0));
    }

    public static int sum(int a, int b) {
        int sum = 0;
        while (a / 10 != 0) {
            sum += a % 10;
            a = a / 10;
        }
        sum += a;
        while (b / 10 != 0) {
            sum += b % 10;
            b = b / 10;
        }
        sum += b;
        return sum;
    }

}
