package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
//        Solution solution = new Solution();

        String inputFileName = args[1];
        String outputFileName = args[2];
        FileInputStream inputStream = new FileInputStream(inputFileName);
        FileOutputStream outputStream = new FileOutputStream(outputFileName);
        byte[] symbol = new byte[1];
        while (inputStream.available() > 0) {
            inputStream.read(symbol);
            if (args[0].equals("-e"))
                symbol = coder(symbol);
            else if (args[0].equals("-d"))
                symbol = decoder(symbol);
            outputStream.write(symbol);
        }
        inputStream.close();
        outputStream.close();
    }

    private static byte[] coder(byte[] symbol) {
        symbol[0] = (byte) ~symbol[0];
        return symbol;
    }

    private static byte[] decoder(byte[] symbol) {
        symbol[0] = (byte) ~symbol[0];
        return symbol;
    }
}
