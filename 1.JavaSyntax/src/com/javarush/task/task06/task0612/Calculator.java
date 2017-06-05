package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a + b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a - b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a * b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double c = (double) a;
        double d = (double) b;
        return c / d;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double c = (double) a;
        double d = (double) b;
        return (c / 100) * d;
    }

    public static void main(String[] args) {
        System.out.println(Calculator.percent(10,2));
    }
}