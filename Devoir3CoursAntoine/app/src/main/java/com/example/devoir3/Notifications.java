package com.example.devoir3;

public class Notifications {
    String title;
    Boolean read;
    String info;
    String classNumber;
    public Notifications(String title, String info,String classNumber){
        this.title =title;
        this.info = info;
        this.classNumber = classNumber;
        this.read = false;
    }
    public Notifications(String title, String info,String classNumber, boolean read){
        this.title =title;
        this.info = info;
        this.classNumber = classNumber;
        this.read = read;
    }


    public String getTitle(){
        return this.title;
    }
    public String getInfo(){
        return this.info;
    }
    public String getClassNumber(){
        return this.classNumber;
    }
    public Boolean getRead(){
        return this.read;
    }
    public void setRead(Boolean read){
        this.read = read;
    }
}
