package com.example.petime;

public class SocietyData {
    private String name;
    private int Id;
    public SocietyData(String name,int id){
        this.name=name;
        this.Id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return Id;
    }

}
