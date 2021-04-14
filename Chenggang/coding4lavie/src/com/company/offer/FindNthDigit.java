package com.company.offer;

import java.util.*;

public class FindNthDigit {
    public static void main(String[] args) {
        int[] numbers = {12,343,1,3,8,9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String[] arrays = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arrays[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arrays, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arrays.length; i++) {
            sb.append(arrays[i]);
        }
        return sb.toString();
    }

}
