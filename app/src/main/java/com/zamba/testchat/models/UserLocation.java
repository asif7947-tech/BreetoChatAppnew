package com.zamba.testchat.models;

public class UserLocation {

 private String crrent_lat;
 private String crrent_long;

    public UserLocation() {

    }

    public UserLocation(String crrent_lat, String crrent_long) {
        this.crrent_lat = crrent_lat;
        this.crrent_long = crrent_long;
    }

    public String getCrrent_lat() {
        return crrent_lat;
    }

    public void setCrrent_lat(String crrent_lat) {
        this.crrent_lat = crrent_lat;
    }

    public String getCrrent_long() {
        return crrent_long;
    }

    public void setCrrent_long(String crrent_long) {
        this.crrent_long = crrent_long;
    }
}
