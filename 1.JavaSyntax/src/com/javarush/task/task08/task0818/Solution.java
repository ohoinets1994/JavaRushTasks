package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("1", 1000);
        map.put("2", 2000);
        map.put("3", 3000);
        map.put("4", 4000);
        map.put("5", 5000);
        map.put("6", 6000);
        map.put("7", 500);
        map.put("8", 1000);
        map.put("9", 300);
        map.put("10", 8000);
//        removeItemFromMap(map);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> s : copy.entrySet()) {
            if (s.getValue() < 500)
                map.remove(s.getKey());
        }
    }

    public static void main(String[] args) {
//        HashMap<String, Integer> a = createMap();
//        removeItemFromMap(a);
//        for (Map.Entry<String,Integer> pairs : a.entrySet())
//            System.out.println(pairs.getValue());

    }
}