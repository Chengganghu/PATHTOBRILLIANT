package com.company.offer;

public class TranslateNum {
    static int res = 0;
    public static void main(String[] args) {
        System.out.println(solution(41960557));
    }

    static int solution(int num) {
        String s = String.valueOf(num);
        recur(s);
        return res;
    }


    static void recur(String s) {
        if (s.length() == 1) {
            res++;
            return;
        } else if (s.length() == 2) {
            if (Integer.valueOf(s) > 25 || s.startsWith("0")) res += 1;
            else res += 2;
        }
        else {
            recur(s.substring(1));
            String s1 = s.substring(0,2);
            if (Integer.valueOf(s1) <= 25 && !s.startsWith("0")) recur(s.substring(2));
        }
    }
}
