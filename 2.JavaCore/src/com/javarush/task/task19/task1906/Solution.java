package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        FileReader readFirstFile = new FileReader(firstFile);
        FileWriter writer = new FileWriter(secondFile);

        int count = 0;
        while (readFirstFile.ready()) {
            int b = readFirstFile.read();
            count++;
            if (count % 2 == 0)
                writer.write(b);
        }
        reader.close();
        readFirstFile.close();
        writer.close();
    }
}
