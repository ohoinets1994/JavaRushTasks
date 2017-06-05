package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader readFile = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
        while (readFile.ready()) {
            String str = readFile.readLine();
            String[] strings = str.split(" ");
            for (String s: strings) {
                // перевіряємо чи строка масива є числом (isNumeric - "[-+]?\\d*\\.?\\d+")
                if (s.matches("[-+]?\\d*\\.?\\d+")) {
                    writer.write(s);
                    writer.write(" ");
                }

            }
        }
        readFile.close();
        writer.close();
    }
}
