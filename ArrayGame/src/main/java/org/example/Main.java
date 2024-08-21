package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args)throws IOException {
        String path = "testnum.txt";
        recordToFile(path);
        readFile(path);
    }

    private static void recordToFile(String path) throws IOException {
        FileOutputStream file = new FileOutputStream(path);
            int[] array = {0, 3, 2, 1, 3, 2, 0, 2, 1};
            int b = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++){
                        b += array[3 * i + j] << (j * 2);
                }
                file.write(b);
            }
       file.close();
    }

    private static void readFile(String path) throws IOException{
        StringBuilder reader = new StringBuilder(path);
        String str = reader.toString();
        int index = 0;
        int[] newArray = new int [9];
        while (index < str.length()) {
            int b = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++){
                        newArray[3 * i + j] = b >> (j * 2);
                }
            }
            index++;
        }
        System.out.println(newArray.toString());
    }
}