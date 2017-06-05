package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;/*
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] arr = new int[4];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(reader.readLine());
        int even_sum = 0;
        int odd_sum = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j == 0 || j % 2 == 0)
                even_sum = even_sum + arr[j];
            else
                odd_sum = odd_sum + arr[j];
        }
        if (odd_sum > even_sum)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else if (even_sum > odd_sum)
            System.out.println("В домах с четными номерами проживает больше жителей.");
    }
}
