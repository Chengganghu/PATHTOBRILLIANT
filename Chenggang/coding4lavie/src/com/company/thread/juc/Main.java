package com.company.thread.juc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {



    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();


        Map<String, String> mapper = new HashMap<>();
        map.put("1", "String");
        map.put("2", "Integer");
        map.put("3", "Character");
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()) {
            System.out.println(((Map.Entry)it.next()).getValue());
            map.remove("3");
        }
    }
}
