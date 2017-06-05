package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getCountSecondsPassedInCurrentHour(12345));
    }

    public static int getCountSecondsPassedInCurrentHour(int seconds) {
        int result = 0;
        while (result <= 3600) {
            result = seconds;
            result = result - (result / 3600) * 3600;
            return result;
        }
        return result;
        //напишите тут ваш код
    }
}