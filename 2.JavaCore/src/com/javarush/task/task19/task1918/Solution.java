package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));

        String str = "";
        while (readFile.ready()) {
            str = str + readFile.readLine();
        }
        reader.close();
        readFile.close();

        ArrayList<Integer> indexStartTeg = new ArrayList<>();
        int index = 0;
        while (true) {
            index = str.indexOf("<" + args[0], index);
            if (index == -1) {
                break;
            }
            indexStartTeg.add(index);
            index++;
        }
        ArrayList<Integer> indexEndTeg = new ArrayList<>();
        index = 0;
        while (true) {
            index = str.indexOf("/" + args[0] + ">", index);
            if (index == -1) {
                break;
            }
            indexEndTeg.add(index);
            index++;
        }
        while (!indexStartTeg.isEmpty()) {
            int n = 0;
            for (int i = 1; i < indexStartTeg.size(); i++) {
                if (indexStartTeg.get(i) < indexEndTeg.get(0))
                    n++;
            }
            String result = str.substring(indexStartTeg.get(0), indexEndTeg.get(n)) + "/" + args[0] + ">";
            System.out.println(result);
            indexStartTeg.remove(0);
            indexEndTeg.remove(n);
        }
    }
}
