package com.company.sort;

import java.util.*;

public class SelectSort {

    public static void selectSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }


    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] array = {3,4,1,6,8,2,3,10};
        System.out.println("before sort:");
        for (int i: array) {
            System.out.print(i + "-->");
        }
        selectSort(array);

        System.out.println("\nafter sort");
        for (int i:array) {
            System.out.print(i + "-->");
        }

        list.add("String");
        list.add("Integer");
        for (String s :
                list) {
            System.out.println(s);
        }

        Map<String, String> map= new HashMap<>();
        map.put("1","String");
        map.put("2", "Ingeger");

        Map<String, String> newMap = new HashMap<>(map);

        map.put("3", "character");

        Iterator it = newMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry)it.next();
            entry.getKey();
            entry.getValue();
        }

        newMap.values().forEach(s -> System.out.println(s));
    }

}
