package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;/*
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        int result = inputStream.read();
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data > result)
                result = data;
        }
        reader.close();
        inputStream.close();
        System.out.println(result);
    }
}
