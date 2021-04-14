package com.company.offer;

import java.util.*;

public class Offer15 {

    public static int hammingWeight(int n) {
        int flag = 1;
        int weight = 0;

        while(flag != 0) {
            if ((flag & n) != 1) {
                weight++;
            }
            flag = flag << 1;
        }
        return weight;
    }

    public static void main(String[] args) {
        hammingWeight(5);
        //System.out.println(4 & 5);

        Map<String, String> map = new HashMap<>();
        map.put("1", "String");
        map.put("2", "Integer");
        map.put("3", "Character");

        Map<String, String> unChangeableMap = Collections.unmodifiableMap(map);
        map.put("4", "Boolean");
        Iterator it = unChangeableMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("key: " + entry.getKey() + "-> value: " + entry.getValue() );
        }
    }



}
