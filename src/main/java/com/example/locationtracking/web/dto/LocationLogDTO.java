package com.example.locationtracking.web.dto;

import com.example.locationtracking.entity.AssetLocationLog;
import com.example.locationtracking.entity.DeviceType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDateTime;

public class LocationLogDTO {

    @JsonFormat(shape = Shape.STRING,  pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime logTime;

    private String location;

    private DeviceType deviceType;

    private String assetId;

    private Long speed;

    private String additionalData;

    public AssetLocationLog toEntity(){
        AssetLocationLog locationLog = new AssetLocationLog();
        locationLog.setAssetId(this.assetId);
        locationLog.setDeviceType(this.deviceType);
        locationLog.setLogTime(this.logTime);
        locationLog.setSpeed(this.speed);
        locationLog.setAdditionalData(this.additionalData);
        return locationLog;
    }

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

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
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
}
