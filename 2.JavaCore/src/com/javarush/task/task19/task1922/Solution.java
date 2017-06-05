package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        while (readFile.ready()) {
            int count = 0;
            String string = readFile.readLine();
            String[] s = string.split(" ");
            for (String a: words) {
                for (String b: s) {
                    if (b.equals(a))
                        count++;
                }
            }
            if (count == 2)
                System.out.println(string);
        }
        readFile.close();
    }
}
