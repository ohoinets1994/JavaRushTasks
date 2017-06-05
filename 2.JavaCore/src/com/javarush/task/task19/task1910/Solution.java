package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader readFile = new BufferedReader(new FileReader(file1));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(file2));
        while (readFile.ready()) {
            String string = readFile.readLine();
//            ділимо по знаках пунктуації
            String[] m = string.split("[\\p{P} \\t\\n\\r]");
            for (String s: m) {
                writeFile.write(s);
            }
        }
        readFile.close();
        writeFile.close();
    }
}
