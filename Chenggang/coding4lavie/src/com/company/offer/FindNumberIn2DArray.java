package com.company.offer;

public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        findNumberIn2DArray(matrix, 5);
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int i = 0, j = width - 1;
        while(i < height && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
