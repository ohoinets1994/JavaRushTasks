package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream (reader.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        while (inputStream.available() > 0) {
            int d = inputStream.read();
            if(map.containsKey(d))
                map.put(d, map.get(d) + 1);
            else
                map.put(d, 1);
        }

        int max = 0;
        for(Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() > max)
                max = (int) entry.getValue();
        }

        for (Map.Entry entry : map.entrySet()) {
            if(entry.getValue().equals(max))
                System.out.print(entry.getKey() + " ");
        }
        reader.close();
        inputStream.close();
    }
}
