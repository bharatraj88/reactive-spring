package com.example.locationtracking.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalTime;

public class AssetTrackingConfigDTO {

    @JsonFormat(shape = Shape.STRING,  pattern = "HH:mm:ss")
    private LocalTime trackFromTime;

    @JsonFormat(shape = Shape.STRING,  pattern = "HH:mm:ss")
    private LocalTime trackToTime;

    @JsonFormat(shape = Shape.STRING,  pattern = "HH:mm:ss")
    private LocalTime trackingFrequency;

    private String deviceId;

    private String manufacturer;

    private String phoneNumber;

    private String userName;

    public LocalTime getTrackFromTime() {
        return trackFromTime;
    }

    public void setTrackFromTime(LocalTime trackFromTime) {
        this.trackFromTime = trackFromTime;
    }

    public LocalTime getTrackToTime() {
        return trackToTime;
    }

    public void setTrackToTime(LocalTime trackToTime) {
        this.trackToTime = trackToTime;
    }

    public LocalTime getTrackingFrequency() {
        return trackingFrequency;
    }

    public void setTrackingFrequency(LocalTime trackingFrequency) {
        this.trackingFrequency = trackingFrequency;
    }

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
