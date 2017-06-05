package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] str = new int[126];
        while (fileInputStream.available() > 0) {
            // при зустрічі одинакового коду символа, ми збільшуємо значення,
            // яке міститься в масиві на позиції, яку обозначає прочитаний байт код символа.
            str[fileInputStream.read()]++;
        }
        fileInputStream.close();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != 0)
                System.out.println((char) i + " " + str[i]);
        }
    }
}
