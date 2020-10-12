package com.zamba.berreto.models;

public class Userdata {

    private String id;
    private String name;
    private String nameToDisplay;
    private String status;
    private String image;
    private String user_name;

    public Userdata(String id, String name, String nameToDisplay, String status, String image, String user_name) {
        this.id = id;
        this.name = name;
        this.nameToDisplay = nameToDisplay;
        this.status = status;
        this.image = image;
        this.user_name = user_name;
    }

    public Userdata() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameToDisplay() {
        return nameToDisplay;
    }

    public void setNameToDisplay(String nameToDisplay) {
        this.nameToDisplay = nameToDisplay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
