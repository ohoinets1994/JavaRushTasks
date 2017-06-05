package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new InfinityThread());
        threads.add(new InExceptionThread());
        threads.add(new JoyThread());
        threads.add(new MessageThread());
        threads.add(new SumThread());
    }

    public static void main(String[] args) throws InterruptedException {

    }

    public static class InfinityThread extends Thread {
        public void run() {
            while (true) {}
        }
    }

    public static class InExceptionThread extends Thread {
        public void run() {
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class JoyThread extends Thread {
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }

    }

    public static class MessageThread extends Thread implements Message {
        public void run() {

        }
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class SumThread extends Thread {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int value;
            int result = 0;
            try {
                while (true) {
                    String str = reader.readLine();
                    if (str.equals("N"))
                        break;
                    else {
                        value = Integer.parseInt(str);
                        result = result + value;
                    }
                }
                System.out.println(result);
            } catch (IOException e) {
            }
        }
    }
}