package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader readFile = new FileReader(fileName);
        StringBuilder builder = new StringBuilder();
        while (readFile.ready()) {
            builder.append((char)readFile.read());
        }
        String s = builder.toString();
        String[] arr = s.split("[^A-Za-z0-9]");//Символы в квадратных скобках указывают интервал возможных буквенных значений.
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("world"))
                count++;
        }

        System.out.println(count);
        readFile.close();
    }
}
