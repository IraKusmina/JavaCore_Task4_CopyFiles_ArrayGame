package org.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{

//        Написать функцию, создающую резервную копию всех файлов в директории
//        (без поддиректорий)
//        во вновь созданную папку ./backup

        File curDir = new File("./src/main/resources");
        File newDir = new File("./backup");
        if (!newDir.exists()){
            newDir.mkdirs();
        }
        getAllFiles(curDir, newDir);
    }

    private static void getAllFiles(File curDir, File newDir) throws IOException {
            ArrayList<File> list = new ArrayList<>();
            File[] filesList = curDir.listFiles();
            for(File f : filesList){
                if(f.isFile()){
                    list.add(f);
                }
            }
            copyFiles(list, curDir, newDir);
        }

    public static void copyFiles(ArrayList<File> list, File oldDir, File newDir) throws IOException {
        for (File f: list){
            String string = makeString(f.getAbsolutePath());
            String newPath = newDir + "\\" + f.getName();
            writeFile(string, newPath);
        }
    }

    public static String makeString(String path) throws IOException {
        try (FileReader reader = new FileReader(path)) {
            int n;
            String string = "";
            while ((n = reader.read()) != -1) {
                char num = (char) n;
                string = string + num;
            }
            return string;
        }
    }

    public static void writeFile(String string, String path){
        try(FileWriter writer = new FileWriter(path)){
            writer.write(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}