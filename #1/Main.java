package com.company;
import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            Scanner stop_u_violated_the_low = new Scanner(System.in);
            File F1 = new File("MyFil1.txt");
            F1.createNewFile();
            File folder = new File("Новая папка");
            folder.mkdir();
            String dir = System.getProperty("user.dir");
            File folderin = new File(dir + "/Не совсем новая папка/немного новая папка/", "Совсем новая папка");
            folderin.mkdirs();

            //упражнение 2
            stop_u_violated_the_low.nextInt();
            if (F1.isFile())
                System.out.println("является файлом: " + F1.getName());
            if (folder.isDirectory())
                System.out.println("является папкой: " + folder.getName());
            if (F1.exists())
                System.out.println("существует ");
            System.out.println(F1.getAbsolutePath() + "");
            System.out.println(F1.length() + " в байтах");
            System.out.println(F1.isFile() ? "Это файл" : "Ето папка");

            //упражнение 3
            stop_u_violated_the_low.nextInt();
            File folder3 = new File("Последняя новая папка");
            folder3.mkdir();
            File mainFile = new File(dir);

            String[] arr = mainFile.list();
            File[] farr = mainFile.listFiles();
            int count = 0;
            for (File t : farr
            ) {
                if (t.isDirectory())
                    count++;
                System.out.println(t.getName());
            }

            int n = stop_u_violated_the_low.nextInt();
            F1.delete();
            folderin.delete();
            folder.delete();
            folder3.delete();
            folderin.delete();
            mainFile.delete();
            File F2 = new File("Не совсем новая папка/немного новая папка");
            F2.delete();
            File F3 = new File("Не совсем новая папка");
            F3.delete();

        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
