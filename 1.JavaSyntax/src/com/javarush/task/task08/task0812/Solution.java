package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> arr = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            arr.add(Integer.parseInt(reader.readLine()));
        }
        int start = arr.get(0);
        int count = 0;
        int result = 0;
        for (Integer value : arr) {
            if (start == value) {
                count++;
                if (count > result)
                    result = count;
            } else {
                start = value;
                count = 1;
            }
        }
        System.out.println(result);
    }
}