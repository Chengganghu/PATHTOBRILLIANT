package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ENCTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Integer[] array = list.toArray(new Integer[0]);

        List<String> listString = Arrays.asList("1", "2", "3", "4", "5");

        String[] arrayString = listString.toArray(new String[0]);
    }

}
