package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        //start here - начни тут
        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
            } else {
                allPeople.add(Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
            }
            System.out.println(allPeople.size() - 1);
        } else if (args[0].equals("-u")) {
            int index = Integer.parseInt(args[1]);
            allPeople.get(index).setName(args[2]);
            allPeople.get(index).setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
            allPeople.get(index).setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
        } else if (args[0].equals("-d")) {
            int index = Integer.parseInt(args[1]);
            allPeople.get(index).setName(null);
            allPeople.get(index).setSex(null);
            allPeople.get(index).setBirthDay(null);
        } else if (args[0].equals("-i")) {
            int index = Integer.parseInt(args[1]);
            String name = allPeople.get(index).getName();
            String sex = allPeople.get(index).getSex() == Sex.MALE ? "м" : "ж";
            System.out.println(name + " " + sex + " " +
                    new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(index).getBirthDay()));
        }
    }
}
