package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String result = "";
        while (reader.ready()) {
            String string = reader.readLine();
            String[] s = string.split(" ");
            for (int i = 0; i < s.length; i++) {
                if (s[i].length() > 6) {
                    result = result + s[i] + " ";
                }
            }
        }
        result = result.trim().replaceAll(" ", ",");
        writer.write(result);
        reader.close();
        writer.close();
    }
}
