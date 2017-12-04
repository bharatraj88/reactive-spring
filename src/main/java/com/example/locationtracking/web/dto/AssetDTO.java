package com.example.locationtracking.web.dto;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.entity.GPSDeviceInfo;
import com.example.locationtracking.entity.MobileAppInfo;
import com.example.locationtracking.entity.TrackingInfo;
import java.util.UUID;

public class AssetDTO {

    private String driverName;

    private DeviceType deviceType;

    private String vehicleNumber;

    private AssetTrackingConfigDTO trackingConfig;

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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Assets toEntity(){
        Assets assets = new Assets();
        assets.setId(UUID.randomUUID().toString().replaceAll("-",""));
        assets.setVehicleNumber(this.vehicleNumber);
        assets.setDeviceType(this.deviceType);
        assets.setDriverName(this.driverName);
        if(this.trackingConfig != null){
            TrackingInfo trackingInfo = null;
            if(DeviceType.GPS_DEVICE.equals(this.deviceType)){
                if(this.trackingConfig.getDeviceId() == null || this.trackingConfig.getManufacturer() == null){
                    throw new RuntimeException(
                            " Device Id and manufacturer is mandatory if you are trying to update device type as GPS");
                }
                trackingInfo = new GPSDeviceInfo(this.trackingConfig.getDeviceId(), this.trackingConfig.getManufacturer());

            }
            else if(DeviceType.MOBILE.equals(this.deviceType)){
                if(this.trackingConfig.getPhoneNumber() == null || this.trackingConfig.getUserName() == null){
                    throw new RuntimeException(
                            " phone number and user name is mandatory if you are trying to update device type as mobile");
                }
                trackingInfo = new MobileAppInfo(this.trackingConfig.getPhoneNumber(), this.trackingConfig.getUserName());
            }
            trackingInfo.setTrackFromTime(this.trackingConfig.getTrackFromTime());
            trackingInfo.setTrackToTime(this.trackingConfig.getTrackToTime());
            trackingInfo.setTrackingFrequency(this.trackingConfig.getTrackingFrequency());
            assets.setTrackingInfo(trackingInfo);
        }
        return assets;
    }

    public AssetTrackingConfigDTO getTrackingConfig() {
        return trackingConfig;
    }

    public void setTrackingConfig(AssetTrackingConfigDTO trackingConfig) {
        this.trackingConfig = trackingConfig;
    }
}
