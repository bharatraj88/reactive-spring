package com.example.locationtracking.entity;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "asset_location_log")
public class AssetLocationLog {

    private LocalDateTime logTime;

    private String location;

    private DeviceType deviceType;

    private Long speed;

    private String additionalData;

    private String driverName;
    
    private String vehicleNumber;

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public void setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    
    public String getVehicleNumber(){
        return this.vehicleNumber;
    }
    
    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }
}
