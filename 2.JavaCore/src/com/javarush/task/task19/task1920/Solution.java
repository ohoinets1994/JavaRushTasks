package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<String, Double>();
        Map<String, Double> newMap = new TreeMap<String, Double>();
        while (reader.ready()) {
            String string = reader.readLine();
            String[] s = string.split(" ");
            if (map.containsKey(s[0])) {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            } else {
                map.put(s[0], Double.parseDouble(s[1]));
            }
        }
        reader.close();
        double max = 0;
        for (Map.Entry<String, Double> s: map.entrySet()) {
            if (s.getValue() >= max) {
                max = s.getValue();
            }
        }
        for (Map.Entry<String, Double> p: map.entrySet()) {
            if (p.getValue() == max) {
                newMap.put(p.getKey(), max);
            }
        }
        for (Map.Entry<String, Double> f: newMap.entrySet()) {
            System.out.print(f.getKey() + " ");
        }
    }
}
