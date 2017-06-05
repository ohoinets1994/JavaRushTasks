package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(-123));
    }

    public static int sumDigitsInNumber(int number) {
        String str = Integer.toString(number);
        int result = 0;
        int k = 0;
        int l = 0;
        if (str.charAt(0) == '-') {
            k = Integer.parseInt(String.valueOf(str.charAt(1))) * (-1);
            l = 2;
        }
        for (int i = l; i < str.length(); i++) {
            result = k + result + Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        return result;
        //напишите тут ваш код
    }
}