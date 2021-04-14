package com.company.offer;

public class PathExist {

    public static char[][] gBoard;
    public static char[] gCharArray;
    public static boolean exist(char[][] board, String word) {
        gBoard = board;
        gCharArray = word.toCharArray();
        return existRecursive(0, 0, 0);
    }

    public static boolean existRecursive(int index, int x, int y) {
        if (x < 0 || y < 0 || x >= gBoard.length || y >= gBoard[0].length) return false;
        char targetValue = gCharArray[index];
        if (gBoard[x][y] == targetValue) {
            if (index == gCharArray.length - 1) return true;
            gBoard[x][y] = '/';
            boolean res = existRecursive(index + 1, x + 1, y) || existRecursive(index + 1, x - 1, y) || existRecursive(index + 1, x, y + 1) || existRecursive(index + 1, x, y - 1);
            gBoard[x][y] = targetValue;
            return res;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        boolean res = exist(new char[][]{{'a','b'}}, "ba");
        System.out.println(res);
    }
}
