package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();

        FileInputStream readSecondFile = new FileInputStream(secondFileName);
        FileInputStream readThirdFile = new FileInputStream(thirdFileName);
        FileOutputStream writeFirstFile = new FileOutputStream(firstFileName);
        while (readSecondFile.available() > 0) {
            byte[] buff = new byte[readSecondFile.available()];
            int i = readSecondFile.read(buff);
            writeFirstFile.write(buff, 0, i);
        }
        while (readThirdFile.available() > 0) {
            byte[] buffer = new byte[readThirdFile.available()];
            int j = readThirdFile.read(buffer);
            writeFirstFile.write(buffer, 0, j);
        }
        readSecondFile.close();
        readThirdFile.close();
        writeFirstFile.close();
    }
}
