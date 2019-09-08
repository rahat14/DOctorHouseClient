package com.metacodersbd.doctorhouse.model;

public class getdoctorProfileModel {

    String  name ,  category  , fee , hospital , time ,uid ;

    public getdoctorProfileModel() {
    }

    public getdoctorProfileModel(String name, String category, String fee, String hospital, String time, String uid) {
        this.name = name;
        this.category = category;
        this.fee = fee;
        this.hospital = hospital;
        this.time = time;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
