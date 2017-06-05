package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        LinkedList<Integer> list = new LinkedList<Integer>();
        while (true) {
            String string = reader.readLine();
//            if (string.equals(""))
//                break;
            int value = Integer.parseInt(string);
            list.add(value);
            if (list.size() == 5)
                break;
        }
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
