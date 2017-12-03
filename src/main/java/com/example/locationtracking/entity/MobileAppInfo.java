package com.example.locationtracking.entity;

public class MobileAppInfo extends TrackingInfo {

    public MobileAppInfo(){

    }

    public MobileAppInfo(String phoneNumber, String userName) {
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }

    private String phoneNumber;

    private String userName;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
