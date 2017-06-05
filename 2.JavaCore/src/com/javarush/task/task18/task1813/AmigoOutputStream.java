package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "F:\\one.txt";
    private FileOutputStream origin;

    public AmigoOutputStream(FileOutputStream origin) throws FileNotFoundException {
        super(fileName);
        this.origin = origin;
    }

    public void write(int b) throws IOException {
        origin.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        origin.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        origin.write(b, off, len);
    }

    public void flush() throws IOException {
        origin.flush();
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();
    }


    public void close() throws IOException {
        origin.flush();
        origin.write("JavaRush © All rights reserved.".getBytes());
        origin.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
