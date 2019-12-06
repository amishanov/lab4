package com.company;

import java.util.Scanner;

public class ClassTask2 {
    private String name;
    private String login;
    private String password;
    private String place;

    ClassTask2(String n, String l, String pw, String pl){
        name = n;
        login = l;
        password = pw;
        place = pl;
    }
    public void InputInfo(){
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine(); sc.nextLine();
        login = sc.nextLine(); sc.nextLine();
        password = sc.nextLine(); sc.nextLine();
        place = sc.nextLine();
    }
    public Client getClient(){
        return new Client(name,login,password,place);
    }
    public void setClient(Client client){
        client.setLogin(login);
        client.setName(name);
        client.setPassword(password);
        client.setPlace(place);
    }
}
