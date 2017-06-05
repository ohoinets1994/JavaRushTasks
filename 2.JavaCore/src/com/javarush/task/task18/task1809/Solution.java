package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();

        FileInputStream first = new FileInputStream(firstFileName);
        FileOutputStream second = new FileOutputStream(secondFileName);

        while (first.available() > 0) {
            byte[] arr = new byte[first.available()];
            int count = first.read(arr);
            for (int i = count - 1; i >= 0; i--) {
                second.write(arr[i]);
            }
        }
        first.close();
        second.close();
    }
}
