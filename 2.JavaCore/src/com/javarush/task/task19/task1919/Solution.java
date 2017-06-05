package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();

        while (reader.ready()) {
            String string = reader.readLine();
            String[] arr = string.split(" ");
            if (map.containsKey(arr[0])) {
                //map.get(arr[0]) повертає значення (value) по ключу arr[0]
                map.put(arr[0], map.get(arr[0]) + Double.parseDouble(arr[1]));
            } else {
                map.put(arr[0], Double.parseDouble(arr[1]));
            }
        }
        for (Map.Entry<String, Double> f: map.entrySet()) {
            System.out.println(f.getKey() + " " + f.getValue());
        }
        reader.close();

        /*ArrayList<String> list = new ArrayList<>();
        while (reader.ready()) {
            String s = reader.readLine();
            list.add(s);
        }
        reader.close();
        for (int i = 0; i < list.size(); ) {
            String string = list.get(i);
            String[] arr1 = string.split(" ");
            double value1 = Double.parseDouble(arr1[1]);
            String name1 = arr1[0];
            list.remove(i);
            for (int j = 0; j < list.size(); j++) {
                String string2 = list.get(j);
                String[] arr2 = string2.split(" ");
                double value2 = Double.parseDouble(arr2[1]);
                String name2 = arr2[0];
                if (name1.equals(name2)) {
                    value1 = value1 + value2;
                    list.remove(j);
                    map.put(name1, value1);
                } else {
                    map.put(name1, value1);
                }
            }
        }
        for (Map.Entry<String, Double> f: map.entrySet()) {
            System.out.println(f.getKey() + " " + f.getValue());
        }
        */
    }
}
