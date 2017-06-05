package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        //start here - начни тут
        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        if (args[i + 1].equals("м")) {
                            String name = args[i];
                            allPeople.add(Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2])));
                        } else {
                            String name = args[i];
                            allPeople.add(Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 2])));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        int index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(args[i + 1]);
                        allPeople.get(index).setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                        allPeople.get(index).setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 3]));
                    }
                }
                break;
            case "-d" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        allPeople.get(index).setName(null);
                        allPeople.get(index).setSex(null);
                        allPeople.get(index).setBirthDay(null);
                    }
                }
                break;
            case "-i" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        int index = Integer.parseInt(args[i]);
                        String name = allPeople.get(index).getName();
                        String sex = allPeople.get(index).getSex() == Sex.MALE ? "м" : "ж";
                        System.out.println(name + " " + sex + " " +
                                new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(index).getBirthDay()));
                    }
                }
                break;
        }
//        for (int index = 0; index < 2; index++) {
//            String name = allPeople.get(index).getName();
//            String sex = allPeople.get(index).getSex() == Sex.MALE ? "м" : "ж";
//            System.out.println(name + " " + sex + " " +
//                    new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(index).getBirthDay()));
//        }
        /*if (args[0].equals("-c")) {
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
        }*/
    }
}
