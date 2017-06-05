package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] arr = str.split(" ");
            int day = Integer.parseInt(arr[3]);
            int month = Integer.parseInt(arr[4]) - 1;
            int year = Integer.parseInt(arr[5]);
            Date date = (new GregorianCalendar(year, month, day)).getTime();
            Person person = new Person(arr[1], arr[2], arr[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
