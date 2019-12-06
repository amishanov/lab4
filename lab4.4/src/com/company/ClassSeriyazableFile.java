package com.company;

import java.io.*;
import java.util.ArrayList;

public class ClassSeriyazableFile {
    private String path;
    private ArrayList<Client> clients;
    ClassSeriyazableFile(String p){
        clients = new ArrayList<>();
        path = p;
    }
    public ArrayList<Client> getClients() {
        return clients;
    }
    public void writeOne(Client client)throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(client);
            out.close();
        }catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public Client readOne()throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
            Client client = (Client) in.readObject();
            in.close();
            return client;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public Object get(){
        return this;
    }
    public void add(Client client){
        clients.add(client);
    }
    public void CollectionSerialization(ArrayList<Client> c)throws IOException {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(c);
            out.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
    public void CollectionDeserialization()throws IOException,ClassNotFoundException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))){
            clients = (ArrayList<Client>) in.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.toString());
        }
    }
    public void CollectionSet(ArrayList<Client>c){
        clients = c;
    }
    public ArrayList<Client> CollectionGet(){
        return clients;
    }
    public void goodOOP1(){
        for (Client client : clients
             ) {
            System.out.println(client.getLogin()+" "+client.getPassword()+" "+client.getPlace());
        }
    }
    public void goodOOP2()throws IOException{
        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            String line;
            while ((line=in.readLine()) != null)
                System.out.println(line);
        }
    }

}
