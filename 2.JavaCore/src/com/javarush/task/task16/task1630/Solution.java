package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String name;
        private StringBuilder sb = new StringBuilder();


        public void setFileName(String fullFileName) {
            name = fullFileName;
        }

        //add your code here - добавьте код тут
        public void run() {
            try {
/*
    JAVA 8 прочитати вміст файла і вивід в консоль
    Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
*/
                BufferedReader reader = new BufferedReader(new FileReader(name));
                String s;
                while ((s = reader.readLine()) != null) {
                    sb.append(s.trim());
                    sb.append(" ");
                }
                reader.close();
            } catch (IOException e) {
            }
        }

        public String getFileContent() {
            return sb.toString().trim();
        }
    }
}
