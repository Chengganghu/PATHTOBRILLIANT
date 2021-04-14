package com.company.entretien;

public class Main {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(0,1));
        ImmutableRGB immutableRGB = new ImmutableRGB(1,2,3);
    }
    public static double solution(int input) {
        double left = 1;
        double right = input;

        double mid = (left + right) / 2;

        while (NotIn(mid * mid, input)) {
            if (mid * mid - input > 0){

            } else {

            }
        }
        return 0;
    }

    public static boolean NotIn(double input, double m) {
        return Math.abs(input - m) > 0.00001;
    }

    public static int[] combine(int[] a1, int[] a2) {
        int length = a1.length + a2.length;
        int[] res = new int[length];

        for (int i = 0, j = 0, k = 0; i < length; i++) {
            if (j == a1.length) {
                res[i] = a2[k++];
            }
            if (k == a2.length) {
                res[i] = a1[j++];
            }
            if (a1[j] < a2[k]) {
                res[i] = a1[j++];
            } else {
                res[i] = a2[k++];
            }
        }
        return res;
    }


}
