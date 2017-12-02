package com.example.locationtracking.web.dto;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceInfo;
import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.entity.DriverMobileInfo;
import com.example.locationtracking.entity.GPSDeviceInfo;
import java.time.LocalTime;
import java.util.UUID;

public class AssetDTO {

    private LocalTime pingFrequency;

    private DeviceType deviceType;

    private String vehicleNumber;

    private String deviceId;

    private String manufacturer;

    private String name;

    private String phoneNumber;

    private String imei;

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

    public Assets toEntity(){
        Assets assets = new Assets();
        assets.setId(UUID.randomUUID().toString().replaceAll("-",""));
        assets.setPingFrequency(this.pingFrequency);
        assets.setVehicleNumber(this.vehicleNumber);
        assets.setDeviceType(this.deviceType);
        DeviceInfo deviceInfo = null;
        if(DeviceType.GPS_DEVICE.equals(this.deviceType)){
            deviceInfo = new GPSDeviceInfo(this.deviceId, this.manufacturer);

        }
        else if(DeviceType.MOBILE.equals(this.deviceType)){
            deviceInfo = new DriverMobileInfo(this.name, this.phoneNumber, this.imei);
        }
        assets.setDeviceInfo(deviceInfo);
        return assets;
    }
}
