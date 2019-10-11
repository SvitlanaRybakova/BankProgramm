package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static void readAllLines() {
        String fileName = "./savedData.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeAllLines(){
        List<String> lines = new ArrayList<>();//if it is an array or something that isn't a list
        lines.add("I want to save");
        lines.add("... this data.");
        lines.add("So I'm writing some lines of stuff.");

        try {
            Path way = Paths.get("./savedData.txt");
            Files.write(way, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeObject(String filename, Object o){
        ObjectOutputStream objectOutputStream = null;// преобразует объект в битики и байты, записыавет в поток
        FileOutputStream fileOutputStream = null; // записывает эти байты в файл
        try{
            fileOutputStream = new FileOutputStream(filename, false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream); // для outputstream нужен конечный путь и это fileOutputStream
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object readObject(String fileName){
        ObjectInputStream objectinputstream = null; // преобразовывает битики в объект
        Object sveta = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName);// открывает файл, создает условия для входящего потока objectinputstream
            objectinputstream = new ObjectInputStream(streamIn);
            sveta = (Object) objectinputstream.readObject();
            objectinputstream .close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sveta;
    }
}

