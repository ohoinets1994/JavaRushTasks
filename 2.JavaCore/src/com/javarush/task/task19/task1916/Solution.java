package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        String secondFile = reader.readLine();
        reader.close();

        BufferedReader file1 = new BufferedReader(new FileReader(firstFile));
        BufferedReader file2 = new BufferedReader(new FileReader(secondFile));

        ArrayList<String> list_1 = new ArrayList<>();
        ArrayList<String> list_2 = new ArrayList<>();

        while (file1.ready()) {
            list_1.add(file1.readLine());
        }
        while (file2.ready()) {
            list_2.add(file2.readLine());
        }
        file1.close();
        file2.close();


        for (int i = 0; i < list_1.size(); i++) {
            try {
                if (list_1.get(i).equals(list_2.get(0))) {
                    lines.add(new LineItem(Type.SAME, list_1.get(i)));
                    list_2.remove(0);
                } else if (list_1.get(i).equals(list_2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, list_2.get(0)));
                    list_2.remove(0);
                    i--;
                } else {
                    lines.add(new LineItem(Type.REMOVED, list_1.get(i)));
                }
            } catch (Exception e) {
                if (list_1.size() >= list_2.size()) {
                    lines.add(new LineItem(Type.REMOVED, list_1.get(i)));
                }
            }
        }
        if (list_2.size() < list_1.size()) {
            lines.add(new LineItem(Type.ADDED, list_2.get(0)));
        }
//        for (LineItem i: lines) {
//            System.out.println(i.type + " " + i.line);
//        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
