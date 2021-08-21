package com.example.petime;

public class TodoList {
    private String textname;
    private String time;
    private String setid;
    private String beginid;
    private String nameid;

    public TodoList() {
    }
    public String getTextname(){
        return textname;
    }
    public String getBeginid() {
        return beginid;
    }
    public String getTime(){
        return time;
    }
    public String getSetid(){
        return setid;
    }
    public String getNameid(){return nameid;}
    public void setTextname(String name){
        textname=name;
    }

    public void setBeginid(String beginid) {
        this.beginid = beginid;
    }

    public void setSetid(String setid) {
        this.setid = setid;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }
}
