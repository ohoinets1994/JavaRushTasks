package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream origin;

    public QuestionFileOutputStream(AmigoOutputStream origin) {
        this.origin = origin;
    }

    @Override
    public void flush() throws IOException {
        origin.flush();
    }

    @Override
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

    public void close() {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            if (reader.readLine().equals("Д")) {
                origin.close();
            }
        } catch (IOException e) {
        }
    }
}

