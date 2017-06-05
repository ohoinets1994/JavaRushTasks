package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double result = 0;
        int count = 0;
        while (true) {
            int input = Integer.parseInt(reader.readLine());
            if (input != -1) {
                result = result + input;
                count++;
            } else {
                System.out.println(result / count);
                return;
            }
        }
        //напишите тут ваш код
    }
}

