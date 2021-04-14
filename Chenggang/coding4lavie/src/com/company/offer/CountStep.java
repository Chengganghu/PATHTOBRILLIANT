package com.company.offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class CountStep {

    public static void main(String[] args) {
        System.out.println(solution(6));
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(10);
        queue.offer(8);
        queue.offer(16);
        queue.offer(3);
        queue.offer(5);
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    static int solution(int input) {
        int[] dp = new int[input + 1];
        dp[0] = 0;
        for (int i = 1; i <= input; i++) {
            dp[i] = Math.min(Math.min(dp[i - 1] + 1, i % 2 == 0 ? dp[i / 2] + 1: Integer.MAX_VALUE), i % 3 == 0 ? dp[i / 3] + 1 : Integer.MAX_VALUE);
        }
        return dp[input];
    }
}
