package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader4 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader5 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader6 = new BufferedReader(new InputStreamReader(System.in));

//        String grandfatherName = reader1.readLine();
        Cat grandfather = new Cat(reader1.readLine(), null, null);
        Cat grandmother = new Cat(reader2.readLine(), null, null);
        Cat father = new Cat(reader3.readLine(), null, grandfather);
        Cat mother = new Cat(reader4.readLine(), grandmother, null);
        Cat sun = new Cat(reader5.readLine(), mother, father);
        Cat dauther = new Cat(reader6.readLine(), mother, father);


//        String motherName = reader.readLine();
//        Cat catMother = new Cat(motherName);

//        String daughterName = reader.readLine();
//        Cat catDaughter = new Cat(daughterName, catMother);

        System.out.println(grandfather);
        System.out.println(grandmother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(sun);
        System.out.println(dauther);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

//        Cat(String name) {
//            this.name = name;
//        }
//
//        Cat(String name, Cat parent) {
//            this.name = name;
//            this.mother = parent;
//        }

        public Cat(String name, Cat parent, Cat parent2) {
            this.name = name;
            this.mother = parent;
            this.father = parent2;
        }

        @Override
        public String toString() {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother " + ", no father";
            else if (mother == null)
                return "Cat name is " + name + ", no mother" + ", father is " + father.name;
            else if (father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }
}