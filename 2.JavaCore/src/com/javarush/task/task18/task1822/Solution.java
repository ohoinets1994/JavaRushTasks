package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        // поток читання файла
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        // строка в яку ми будемо построчно считувати з файла
        String string;
        // построчно читаємо файл
        while ((string = readFile.readLine()) != null) {
            //знаходимо перше входження пробілу
            int position = string.indexOf(' ');
            String s = string.substring(0, position);
            if (s.equals(args[0])) {
                System.out.println(string);
            }
        }
        readFile.close();
    }
}
