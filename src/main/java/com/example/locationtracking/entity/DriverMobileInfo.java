package com.example.locationtracking.entity;

public class DriverMobileInfo  extends  DeviceInfo{

    public DriverMobileInfo(){

    }

    public DriverMobileInfo(String name, String phoneNumber, String imei) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imei = imei;
    }

    private String name;

    private String phoneNumber;

    private String imei;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
