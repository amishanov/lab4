package com.company;
import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args)throws IOException {
        try{
        //Упражнение 1
        File f = new File("T2.txt"); f.createNewFile();
        FileReader read = new FileReader("T1.txt");
        FileWriter write = new FileWriter("T2.txt");
        int x;
        while((x = read.read()) != -1)
        {
            write.write(x);
        }
        read.close();
        write.close();

        //Упражнение 2
        f = new File("A.txt");
        f = new File("B.txt");
        write = new FileWriter("A.txt");
        for (int i = 0; i<512;i++)
            write.write("a");
        write.close();
        BufferedReader inb = new BufferedReader(new FileReader("A.txt"),128);
        BufferedWriter outb = new BufferedWriter(new FileWriter("B.txt"),128);
        char []buf = new char[128];
        while((inb.read(buf))!=-1){
            outb.write(buf);
            System.out.println(1);}
        inb.close(); outb.close();

        //Упражнение 3(если что, второй файл А - с русской буквой)
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("А.txt"), "Cp1251"));
        System.out.println(Charset.defaultCharset().name());
        String str;
        str=in.readLine();
        System.out.println(str);
        in = new BufferedReader(new InputStreamReader(new FileInputStream("А.txt"), "UTF8"));
        str=in.readLine();
        System.out.println(str);
        }catch (IOException e){
        System.out.println(e.toString());
        }
    }
}