package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
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
            for (String x: s) {
                // (".*\\d.*") - означает "Слово состоит из любых символов в любом количестве
                // (в том числе и нулевых количествах), а где-то между символами есть число."
                if (x.matches(".*\\d.*")) {
                    result = result + x + " ";
                }
            }
        }
        result = result.trim();
        writer.write(result);
        reader.close();
        writer.close();
    }
}
