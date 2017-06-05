package com.javarush.task.task19.task1909;

/* 
Замена знаков
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
        while(readFile.ready()) {
            String string = readFile.readLine();
            String result = "";
            // перевіряємо чи прочитана строка містить ".", якщо так, то замінюємо її на "!"
            if (string.contains("."))
                result = string.replace(".", "!");
            writeFile.write(result + "\n");
//            System.out.println(result);
        }
        readFile.close();
        writeFile.close();
    }
}
