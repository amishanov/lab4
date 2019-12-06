package com.company;

import java.io.*;
import java.util.ArrayList;

public class StudStream {
    private File file;
    private DataInputStream input;
    private DataOutputStream output;
    private RandomAccessFile randFile;
    public boolean FileCreate(String fileName) throws IOException{
        try {
        file=new File(fileName);
        if (!file.exists()){
            file.createNewFile();
            input=new DataInputStream(new FileInputStream(file));
            output = new DataOutputStream(new FileOutputStream(file));
            return true;
        }
        else{
            input=new DataInputStream(new FileInputStream(file));
            output = new DataOutputStream(new FileOutputStream(file));
            return false;
        }
        }catch (IOException e){
            System.out.println(e.toString());
            return false;
        }
    }
    public void OutputInfo(Student student) throws IOException{
        try {
            output.writeUTF(student.getFirstName());
            output.writeUTF(student.getLastName());
            output.writeInt(student.getRecBookNum());
            output.writeUTF(student.getBirthDate());
            output.writeUTF(student.getEnrollmentDate());
            output.writeUTF(student.getPhoneNumber());
            output.writeUTF(student.getGroupNumber());
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
    public void InputInfo(Student student) throws IOException{
        try {
            student.setFirstName(input.readUTF());
            student.setLastName(input.readUTF());
            student.setRecBookNum(input.readInt());
            student.setBirthDate(input.readUTF());
            student.setEnrollmentDate(input.readUTF());
            student.setPhoneNumber(input.readUTF());
            student.setGroupNumber(input.readUTF());
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
    public ArrayList<Student> FullInput(String group) throws IOException{
        try{
        ArrayList<Student> result=new ArrayList<>();
        Student tempS;
        while ((input.available()>0)){
            tempS = new Student();
            this.InputInfo(tempS);
            if (group.equals(tempS.getGroupNumber()))
                result.add(tempS);
        }
        return result;
        }catch (IOException e){
            System.out.println(e.toString());
            return null;
        }
    }
    public String StringSlitter(Student student){
        return "";
    }
    public static String StringCreate(Student s){ //преобразует в строку
        StringBuffer result = new StringBuffer();
        result.append(s.getFirstName()); result.setLength(20);
        result.append(s.getLastName()); result.setLength(40);
        result.append(s.getRecBookNum()); result.setLength(60);
        result.append(s.getBirthDate()); result.setLength(80);
        result.append(s.getEnrollmentDate()); result.setLength(100);
        result.append(s.getPhoneNumber()); result.setLength(120);
        result.append(s.getGroupNumber()); result.setLength(140);
        result.append("\n");
        return result.toString();
    }
    public void Task5(ArrayList<Student>students,File file,int num) throws IOException {
        try {
            long position = 0, position2 = 40;
            String tempStr = "";
            randFile = new RandomAccessFile(file, "rw");
            for (Student s : students //записываем все в файл
            ) {
                tempStr = StringCreate(s);
                randFile.writeBytes(tempStr);
                position = randFile.getFilePointer();
            }
            tempStr = "";
            while (position2 < position) { //проходим весь файл
                randFile.seek(position2);
                tempStr = "";
                int c;
                while (47 < (c = randFile.read()) && c < 58)
                    tempStr += (char) c; //получаем весь номер

                if (Integer.parseInt(tempStr) == num) {
                    StringBuffer gaf = new StringBuffer();
                    gaf.setLength(140); //создаем пустую строку на 140 символов
                    randFile.seek(position2 - 40); //перемещаем курсор в начало записи
                    //randFile.writeBytes(gaf.toString()); эта строка нужна, если мы хотим удалять последнюю запись
                    randFile.seek(position - 141); //берем последнюю запись
                    tempStr = randFile.readLine(); //считываем до конца строки
                    randFile.seek(position - 141);
                    randFile.writeBytes(gaf.toString()); //заменяем последнюю запись на пустую
                    randFile.seek(position2 - 40);
                    randFile.writeBytes(tempStr); //заменяем нужную запись
                    position2 = position; //создаем условия для выхода из цикла
                }
                position2 += 141;
            }
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}