package com.metacodersbd.doctorhouse.model;

public class getHospitalmodel {

    String name , id , location , imageLink  ;

    public getHospitalmodel() {
    }

    public getHospitalmodel(String name, String id, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
    }

    public getHospitalmodel(String name, String id, String location, String imageLink) {
        this.name = name;
        this.id = id;
        this.location = location;
        this.imageLink = imageLink;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
