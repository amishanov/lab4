package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ClassTextFile {
    private String path;
    ClassTextFile(String path){
        if (!new File(path).exists())
            System.out.println("Этого файла не существует");
        else
            this.path = path;
    }
    public Client InputObject()throws FileNotFoundException{
        Scanner sc = new Scanner(new File(path));
        String name = sc.nextLine();
        String login = sc.nextLine();
        String password = sc.nextLine();
        String place = sc.nextLine();
        sc.close();
        return new Client(name,login,password,place);
    }
}
