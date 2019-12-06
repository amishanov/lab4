package com.company;
import java.io.*;

public class User implements Serializable{
    private String name;
    private String login;
    private String password;
    User(){
        name=null;login=null;password=null;
    }
    User(String name, String login, String password){
        this.name=name; this.login=login; this.password=password;
    }
    public boolean enter(String login, String password){
        return (this.login==login & this.password==password);
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getPlace(){ return null; }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Client extends User{
    private String place;
    Client(String n, String l, String p, String place){
        super(n,l,p);
        this.place=place;
    }
    @Override
    public String getPlace(){
        return place;
    }
    public void setPlace(String s){
        place=s;
    }
}