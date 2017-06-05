package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        BufferedReader firstfilereader = new BufferedReader(new FileReader(firstFileName));
        String str1;
        while ((str1 = firstfilereader.readLine()) != null) {
            allLines.add(str1);
        }
        BufferedReader secondfilereader = new BufferedReader(new FileReader(secondFileName));
        String str2;
        while ((str2 = secondfilereader.readLine()) != null) {
            forRemoveLines.add(str2);
        }
        reader.close();
        firstfilereader.close();
        secondfilereader.close();
        Solution sol = new Solution();
        try {
//            System.out.println("allLines до видалення");
//            System.out.println(allLines);
            sol.joinData();
        } catch (CorruptedDataException e) {}
//        System.out.println(forRemoveLines);
//        System.out.println("allLines після видалення");
//        System.out.println(allLines);
    }

    public void joinData() throws CorruptedDataException {
//        з форума )))
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
/* мій код )))
        int count = 0;
        int sizeallLines = allLines.size();
        for (int j = 0; j < forRemoveLines.size(); j++) {
            for (int i = 0; i < sizeallLines; i++) {
                if (forRemoveLines.get(j).equals(allLines.get(i))) {
                    allLines.remove(i);
                    sizeallLines = sizeallLines - 1;
                    count++;
                }
            }
        }
        if (count == 0) {
            allLines.clear();
            throw new CorruptedDataException();
        }
*/
    }
}
