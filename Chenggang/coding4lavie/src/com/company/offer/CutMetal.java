package com.company.offer;

import java.util.Arrays;

public class CutMetal {

    public static int[] prices = {1,5,8,9,10,17,17,20,24,30};

    public static int cutMetal(int length) {
        int[] dp = new int[length + 1];
        dp[0] = 0;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], prices[j - 1] + dp[i - j]);
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(cutMetal(4));
        System.out.println(3 & 1);
    }
}
