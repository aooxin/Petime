package com.example.petime;

import android.app.Application;

public class Data extends Application {
    private int data_cat;
    private int data_dog;
    private int data_unicorn;
    private int data_fox;
    private int data_squirrel;
    private int data_rabbit;
    private int arwad;
    Data(){
        data_unicorn=60;
        data_squirrel=60;
        data_rabbit=60;
        data_fox=60;
        data_dog=60;
        data_cat=60;
        arwad=100;
    }
    public int getArwad() {
        return arwad;
    }

    public void setArwad(int arwad) {
        this.arwad = arwad;
    }

    public int getData_cat(){
        return this.data_cat;
    }
    public int getData_dog() {
        return data_dog;
    }
    public int getData_fox() {
        return data_fox;
    }
    public int getData_rabbit() {
        return data_rabbit;
    }
    public int getData_unicorn() {
        return data_unicorn;
    }
    public int getData_squirrel() {
        return data_squirrel;
    }
    public void setData_cat(int c){
        this.data_cat= c;
    }
    public void setData_dog(int data_dog) {
        this.data_dog = data_dog;
    }
    public void setData_fox(int data_fox) {
        this.data_fox = data_fox;
    }
    public void setData_rabbit(int data_rabbit) {
        this.data_rabbit = data_rabbit;
    }
    public void setData_squirrel(int data_squirrel) {
        this.data_squirrel = data_squirrel;
    }
    public void setData_unicorn(int data_unicorn) {
        this.data_unicorn = data_unicorn;
    }
    @Override
    public void onCreate(){
        this.data_cat=60;
        this.data_dog=60;
        this.data_fox=60;
        this.data_rabbit=60;
        this.data_squirrel=60;
        this.data_unicorn=60;
        super.onCreate();
    }
}
 class Exp{
    private static int exp=0;
    public void exp_add(int time){
        this.exp+=time;
    }
 }