package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;/*
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        String shortstr = list.get(0);
        String longstr = list.get(0);
        for (String s : list) {
            if (shortstr.length() > s.length())
                shortstr = s;
            else if (longstr.length() < s.length())
                longstr = s;
        }
        String result;
        if (list.indexOf(shortstr) < list.indexOf(longstr))
            result = shortstr;
        else
            result = longstr;
        System.out.println(result);
    }
}
