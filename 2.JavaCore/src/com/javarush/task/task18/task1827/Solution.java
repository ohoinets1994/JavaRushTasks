package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (!("-c".equals(args[0])))
            return;
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        fileName = reader.readLine();
        BufferedReader readerF = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        Long id = new Long(0);
        String str;
        String tmp;
        while (readerF.ready()) {
            list.add(str = readerF.readLine());
            int k = str.indexOf(" ");
            if (k > 8)
                tmp = str.substring(0, 8);
            else
                tmp = str.substring(0, k);
            if (Long.parseLong(tmp) > id)
                id = Long.parseLong(tmp);
        }

        tmp = String.format("%-8d%-30.30s%-8s%-4s", (++id), productName, price, quantity);
        BufferedWriter writerF = new BufferedWriter(new FileWriter(fileName));
        for (String s : list)
            writerF.write(s + "\n");
        writerF.write(tmp.toString());
        reader.close();
        readerF.close();
        writerF.close();

        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if (!(args[0].equals("-c"))) {
            return;
        }
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String string;
        String tmp;
        int id = 0;
        while ((string = readFile.readLine()) != null) {
            list.add(string);
            int space = string.indexOf(" ");
            tmp = string.substring(0, space);
            if (Integer.parseInt(tmp) > id)
                id = Integer.parseInt(tmp);
        }
        int newId = id + 1;
        tmp = String.format ("%-8s%-30s%-8s%-4s", newId, productName, price, quantity);
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName));
        for (String s : list) {
            writeFile.write(s);
            writeFile.write("\n");
        }
        writeFile.write(tmp);
        reader.close();
        readFile.close();
        writeFile.close();*/
    }
}
