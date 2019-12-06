package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args)throws IOException,ClassNotFoundException {
        //Первое задание
        ClassTextFile ctf = new ClassTextFile("text.txt");
        Client c = ctf.InputObject();
        System.out.println(c.getPlace() + " " + c.getLogin() + " " + c.getPassword()+"\n");

        //Второе задание
        //Client c= new Client("","","","");
        ClassTask2 t2 = new ClassTask2("i","f","g","h");
        t2.setClient(c);
        System.out.println(c.getPlace() + " " + c.getLogin() + " " + c.getPassword()+'\n');

        //третье задание
        ClassSeriyazableFile sf = new ClassSeriyazableFile("Clients.txt");
        Client a = new Client("1","2","3","4");
        Client b = new Client("5", "6", "7", "8");
        Client d = new Client("9", "o","0","l");
        ArrayList<Client> testList = new ArrayList<>();
        testList.add(a); testList.add(b); testList.add(d);
        sf.CollectionSerialization(testList); //добавили коллекцию файл
        sf.CollectionDeserialization(); //добавили коллекцию из файла в коллекцию в классе
        sf.goodOOP1(); //вывели коллекцию класса

        sf.writeOne(c); //записали "c" в файл
        a = sf.readOne(); //прочитали "c" из файла в "a"
        System.out.println(a.getPlace() + " " + a.getLogin() + " " + a.getPassword()+'\n');
    }
}
