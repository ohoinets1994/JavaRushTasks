package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        String thirdFileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(firstFileName);
        FileOutputStream outputStreamSecondFile = new FileOutputStream(secondFileName);
        FileOutputStream outputStreamThirdFile = new FileOutputStream(thirdFileName);
        while (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            if (count % 2 == 0) {
                outputStreamSecondFile.write(buffer, 0, count / 2);
                outputStreamThirdFile.write(buffer, count / 2, count / 2);
            } else {
                outputStreamSecondFile.write(buffer, 0, count / 2 + 1);
                outputStreamThirdFile.write(buffer, count / 2 + 1, count - (count / 2 + 1));
            }
        }
        inputStream.close();
        outputStreamSecondFile.close();
        outputStreamThirdFile.close();
    }
}
