package com.company.offer;

import java.util.Scanner;

public class Fib {

    public static int fib(int input) {
        if (input == 1) return 1;
        if (input == 0) return 0;
        return fib(input - 1) + fib(input - 2);
    }

    public static int fibAdvanced(int input) {
        int[] dp = new int[1000];
        dp[0] = 0;
        dp[1] = 1;
        int i = 2;
        while (i <= input) {
            dp[i] = dp[i - 1] + dp[i - 2];
            i++;
        }
        return dp[input];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("input a number");
            int input = scanner.nextInt(), res;
            long start, end, duration;
            start = System.currentTimeMillis();
//            res = fib(input);
//            end = System.currentTimeMillis();
//            duration = end - start;
//            System.out.println("fib(" + input + ") = " + res + ", spend " + duration + " milliseconds" );

            start = System.currentTimeMillis();
            res = fibAdvanced(input);
            end = System.currentTimeMillis();
            duration = end - start;
            System.out.println("fibAdvanced(" + input + ") = " + res + ", spend " + duration + " millseconds" );

        }


    }
}
