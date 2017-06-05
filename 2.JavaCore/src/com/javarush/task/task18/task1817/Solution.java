package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        double symbol = 0;
        double gap = 0;
        while (inputStream.available() > 0) {
            int read = inputStream.read();
            if (read >= 32 && read <= 125)
                symbol++;
            if (read == ' ')
                gap++;
        }
        double result = gap / symbol * 100;
        //округляємо до сотих
        result = result * 100;
        int i = (int) Math.round(result);
        result = (double) i / 100;
        System.out.println(result);
        inputStream.close();
    }
}
