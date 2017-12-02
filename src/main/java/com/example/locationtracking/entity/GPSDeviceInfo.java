package com.example.locationtracking.entity;

public class GPSDeviceInfo extends DeviceInfo {

    public GPSDeviceInfo(){

    }

    public GPSDeviceInfo(String deviceId, String manufacturer) {
        this.deviceId = deviceId;
        this.manufacturer = manufacturer;
    }

    private String deviceId;

    private String manufacturer;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
