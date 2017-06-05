package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        FileInputStream readFirstFile = new FileInputStream(firstFileName);
        byte[] first = new byte[readFirstFile.available()];
        int i = readFirstFile.read(first);

        FileOutputStream writeFirstFile = new FileOutputStream(firstFileName);

        FileInputStream readSecondFile = new FileInputStream(secondFileName);
        byte[] second = new byte[readSecondFile.available()];
        int k = readSecondFile.read(second);

        writeFirstFile.write(second, 0, k);
        writeFirstFile.write(first, 0, i);

        readFirstFile.close();
        readSecondFile.close();
        writeFirstFile.close();
        reader.close();
    }
}
