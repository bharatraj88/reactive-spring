package com.example.locationtracking.entity;

import java.time.LocalTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asset_info")
public class Assets {

    @Id
    private String id;

    private LocalTime pingFrequency;

    private DeviceType deviceType;

    @Indexed(unique = true)
    private String vehicleNumber;

    private DeviceInfo deviceInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getPingFrequency() {
        return pingFrequency;
    }

    public void setPingFrequency(LocalTime pingFrequency) {
        this.pingFrequency = pingFrequency;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }
}
