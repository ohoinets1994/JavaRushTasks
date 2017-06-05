package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();
        System.setOut(consoleStream);

        String number = result.replaceAll("\\D", " ");
        String[] numberArr = number.split("   ");
        int a = Integer.parseInt(numberArr[0]);
        int b = Integer.parseInt(numberArr[1]);
        if (result.contains("+"))
            System.out.println(numberArr[0] + " + " + numberArr[1] + " = " + (a + b));
        else if (result.contains("-"))
            System.out.println(numberArr[0] + " - " + numberArr[1] + " = " + (a - b));
        else if (result.contains("*"))
            System.out.println(numberArr[0] + " * " + numberArr[1] + " = " + (a * b));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

