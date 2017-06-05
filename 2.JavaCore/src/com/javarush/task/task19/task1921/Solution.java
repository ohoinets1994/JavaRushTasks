package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String string = reader.readLine();
            String[] s = string.split(" ");
            String name = "";
            int day = Integer.parseInt(s[s.length - 3]);
            int month = Integer.parseInt(s[s.length - 2]);
            int year = Integer.parseInt(s[s.length - 1]);
            // обробка дати
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date birthday = simpleDateFormat.parse(day + " " + month + " " + year);
            for (int i = 0; i < s.length - 3; i++) {
                    name = name + s[i] + " ";
            }
            name = name.trim();
            PEOPLE.add(new Person(name, birthday));
        }
//        for (Person s: PEOPLE) {
//            System.out.println(s.getName() + " " + s.getBirthday());
//        }
        reader.close();
    }
}
