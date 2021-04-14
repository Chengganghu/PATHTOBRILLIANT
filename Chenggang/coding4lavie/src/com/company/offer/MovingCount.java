package com.company.offer;

public class MovingCount {
    public static int res = 0;
    public static boolean[] visited;
    public static int movingCount(int m, int n, int k) {
        visited = new boolean[m * n];
        for (int i = 0; i < m * n -1; i++) {
            visited[i] = false;
        }
        backTrack(0, 0, m, n, k);
        return res;
    }

    public static void backTrack(int i, int j, int m, int n, int k) {
        if (i > m -1 || i < 0 || j > n - 1|| j <0 || sum(i,j) > k || visited[i * m + j]) {
            return;
        }
        visited[i * m + j] = true;
        res++;
        backTrack(i, j + 1, m ,n ,k);
        backTrack(i, j - 1, m ,n ,k);
        backTrack(i + 1, j, m ,n ,k);
        backTrack(i - 1, j, m ,n ,k);
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

    public static void main(String[] args) {
        movingCount(1,2,1);
    }
}
