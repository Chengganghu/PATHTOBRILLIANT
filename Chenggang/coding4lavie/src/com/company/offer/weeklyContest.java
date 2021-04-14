package com.company.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class weeklyContest {

    public static boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int length = s.length(), diff;
        Map<Integer, Integer> map = new HashMap<>();
        int limits = k / 26;
        int extraLimits = k % 26;
        for (int i = 0; i < length; i++) {
            diff = (t.charAt(i) - s.charAt(i) + 26) % 26;
            if (diff > k) return false;
            else if (diff != 0){
                if (map.containsKey(diff)) {
                    int finalLimits = (diff <= extraLimits ? limits + 1 : limits);
                    if (map.get(diff) == finalLimits) return false;
                    else map.put(diff, map.get(diff) + 1);
                } else {
                    map.put(diff, 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "atmtxzjkz";
        String t = "tvbtjhvjd";
        int n = 35;
        canConvertString(s, t, 35);
    }
}
