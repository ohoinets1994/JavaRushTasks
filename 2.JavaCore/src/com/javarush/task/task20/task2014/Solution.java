package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        FileOutputStream fs = new FileOutputStream("test.txt");
        ObjectOutputStream os = new ObjectOutputStream(fs);
        FileInputStream fi = new FileInputStream("test.txt");
        ObjectInputStream oi = new ObjectInputStream(fi);

        Solution savedObject = new Solution(5);
        os.writeObject(savedObject);
        Solution loadedObject = (Solution) oi.readObject();
        if(loadedObject.string.equals(savedObject.string)) {
            savedObject = loadedObject;
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
