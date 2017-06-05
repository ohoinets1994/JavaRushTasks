package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        while (readFile.ready()) {
            list.add(readFile.readLine());
        }
        reader.close();
        readFile.close();
        String id = args[1];
        String productName = null;
        String price = null;
        String quantity = null;
        String tmp;
        boolean b = false;
//        if (args[0].equals("-d")) {
//            id = args[1];
        if (args[0].equals("-u")) {
            id = args[1];
            productName = args[2];
            price = args[3];
            quantity = args[4];
            b = true;
        }
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int space = s.indexOf(" ");
            if (space > 8)
                tmp = s.substring(0, 8);
            else
                tmp = s.substring(0, space);
            if (Long.parseLong(tmp) != Long.parseLong(id)) {
                writerFile.write(s);
                if (i != list.size() - 1)
                    writerFile.write("\n");
            } else {
                if (b) {
                    tmp = String.format("%-8s%-30.30s%-8s%-4s", id, productName, price, quantity);
                    writerFile.write(tmp);
                    if (i != list.size() - 1)
                        writerFile.write("\n");
                }
            }
        }
        writerFile.close();
    }
}
