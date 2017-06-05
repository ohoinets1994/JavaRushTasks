package com.javarush.task.task19.task1926;

/* 
Перевертыши
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
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        while (reader1.ready()) {
            String string = reader1.readLine();
            StringBuilder stringBuilder = new StringBuilder(string);
            System.out.println(stringBuilder.reverse());
        }
        reader1.close();
    }
}
