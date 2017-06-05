package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream (reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        while(inputStream.available() > 0){
            int value = inputStream.read();
            if (!list.contains(value))
                list.add(value);
        }
        Collections.sort(list);
        for(Integer x : list){
            System.out.print(x + " ");
        }

        reader.close();
        inputStream.close();
//через MAP
//        Map<Integer, Integer> map = new HashMap<>();
//        while (inputStream.available() > 0) {
//            map.put(inputStream.read(), 1);
//        }
//        for (Map.Entry val : map.entrySet()) {
//            System.out.print(val.getKey() + " ");
//        }
//        reader.close();
//        inputStream.close();
/* через LIST моя
        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            int d = inputStream.read();
            list.add(d);
        }
        Collections.sort(list);
        int value = list.get(0);
        System.out.print(value);
        for (int i = 0; i < list.size(); i++) {
            if (value != list.get(i)) {
                 value = list.get(i);
                 System.out.print(" " + value);
             }
        }

        reader.close();
        inputStream.close();
        */
    }
}

