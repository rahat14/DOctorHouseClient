package com.metacodersbd.doctorhouse.model;

public class getuserProfilemodle {


    String name , gender , age  , uid  ;

    public getuserProfilemodle() {
    }

    public getuserProfilemodle(String name, String gender, String age, String uid) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public getuserProfilemodle(String name, String gender, String age ) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
