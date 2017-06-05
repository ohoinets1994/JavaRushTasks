package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();

        FileInputStream inputStream = new FileInputStream(firstFile);
        FileOutputStream outputStream = new FileOutputStream(secondFile);
        while (inputStream.available() > 0) {
            byte[] buff = new byte[inputStream.available()];
            int i = inputStream.read(buff);
            // получения строки из мссива байт(byte[])
            String string = new String(buff, "UTF-8");
            // розделяем строку по пробелам на массив строк
            String[] numbers = string.split(" ");
            for (int j = 0; j < numbers.length; j++) {
                // приводим строковое представление числа к дробному
                Double value = Double.parseDouble(numbers[j]);
                // округляем дробные до целых
                int result = (int) Math.round(value);
                // переводим число в строку
                String s = Integer.toString(result);
                String s2 = s + " ";
                // разбиваем строку на массив символов
                char[] chars = s2.toCharArray();
                byte[] buffer = new byte[chars.length];
                // посимвольно записываем з массива символов в массив байтов
                for (int k = 0; k < buffer.length; k++) {
                    buffer[k] = (byte) chars[k];
                }
                outputStream.write(buffer);
            }
        }
        reader.close();
        inputStream.close();
        outputStream.close();
    }
}
