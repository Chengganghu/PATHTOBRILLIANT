package com.company.sort;

public class HeapSort {
    public static void heapSort(int[] array) {
        if (array.length <= 1) return;
        buildHeap(array);
        int len = array.length;
        for (int i = len - 1; i >= 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i - 1);
        }

    }

    public static void buildHeap(int[] array) {
        for (int i = array.length/2 - 1; i >= 0; i--){
            adjustHeap(array, i, array.length - 1);
        }
    }

    public static void adjustHeap(int[] array, int index, int boarder) {
        int maxIndex = index;
        int rightChildIndex = index * 2 + 2;
        int leftChildIndex = index * 2 + 1;
        // 有左子树，且左子树值大于父节点
        if (leftChildIndex <= boarder  && array[leftChildIndex] > array[maxIndex]) {
            maxIndex = leftChildIndex;
        }
        // 有右子树，且右子树值大于父节点
        if (rightChildIndex <= boarder && array[rightChildIndex] > array[maxIndex]) {
            maxIndex = rightChildIndex;
        }
        if (maxIndex != index) {
            swap(array, index, maxIndex);
            adjustHeap(array, maxIndex, boarder);
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
        heapSort(array);

        System.out.println("\nafter sort");
        for (int i:array) {
            System.out.print(i + "-->");
        }
    }
}
