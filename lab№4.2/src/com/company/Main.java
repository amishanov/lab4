package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException,Exception {
        Student a=new Student("A","A2",15,"12.12.2000","8-800-555-35-35","28.08.2016","IKBO-08");
        Student b=new Student("B","B2",16,"12.12.3123","8-805-35-35","28.08.2016","IKBO-08");
        Student c=new Student("C","C2",17,"12.12.2005","8","28.08.2015","IKBO-07");
        Student d=new Student("D","D2",20,"12.11.2003","35","28.08.2016","IKBO-08");
        File f = new File("tempFile.txt"); f.delete();
        StudStream t=new StudStream();
        Student temp;
        ArrayList<Student> tempList= new ArrayList<>();
        System.out.println("Введите имя файла: ");
        Scanner sc = new Scanner(System.in);
        while (!t.FileCreate(sc.nextLine())){
            System.out.println("Такой файл уже существует, введите другое имя: ");
        }
        System.out.println("Сколько вы хотите записать объектов? ");
        int count  = sc.nextInt(); sc.nextLine();
        System.out.println("Последовательно введите через enter: Имя-Фамилию-Номер зачетной книжки-Дату рождения-Номер телефона-Дату зачисления-Группу");
        for (int i = 0; i<count; i++){
            System.out.println("Вводите: ");
            String fn = sc.nextLine(); String ln = sc.nextLine(); int rbn = sc.nextInt(); sc.nextLine(); String bd = sc.nextLine(); String pn = sc.nextLine();String ed = sc.nextLine(); String gn = sc.nextLine();
            temp = new Student(fn, ln, rbn, bd, pn, ed, gn);
            t.OutputInfo(temp);

        }

        //Здесь начинается пункт 4
        System.out.println("Введите номер группы:");
        tempList=t.FullInput(sc.nextLine());
        System.out.println("Список студентов этой группы из файла: ");
        for (Student s: tempList
             ) {
            System.out.println(s.getFirstName()+" "+s.getLastName()+" "+s.getRecBookNum()+" "+s.getBirthDate()+" "+s.getEnrollmentDate()+" "+s.getPhoneNumber()+" "+s.getGroupNumber());
        }

        //Пункт 5
        File tempFile=new File("tempFile.txt");
        tempFile.createNewFile();
        System.out.println("Введите номер зачетной книжки студента, которого хотите убрать из файла");
        t.Task5(tempList,tempFile,sc.nextInt());

    }

}
