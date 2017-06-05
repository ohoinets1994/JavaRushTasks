package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            ReadThread thread = new ReadThread(fileName);
            thread.start();
        }
        reader.close();
//        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
//            System.out.println("FileName: " + entry.getKey()+ ";" + " Symbol: " + entry.getValue());
//        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                int[] arr = new int[126];
                while (inputStream.available() > 0)
                    arr[inputStream.read()]++;
                int max = 0;
                int result = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                        result = i;
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileName, result);
                }
//                System.out.println(result);
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
