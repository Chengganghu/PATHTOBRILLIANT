package com.company.offer;

public class N19IsMatch {
    public static boolean isMatch(String s, String p) {
        return isMatchCore(s, p);
    }

    public static boolean isMatchCore(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() != 0 && p.length() == 0) return false;
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (s.charAt(0) == p.charAt(0) || (p.charAt(0) == '.'))
                return isMatchCore(s.substring(1), p.substring(2))
                        || isMatchCore(s.substring(1), p)
                        || isMatchCore(s, p.substring(2));
            else return isMatchCore(s, p.substring(2));
        } else  if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'){
            return isMatchCore(s.substring(1), p.substring(1));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
    }
}
