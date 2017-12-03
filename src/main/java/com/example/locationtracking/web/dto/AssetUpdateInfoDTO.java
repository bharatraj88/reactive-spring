package com.example.locationtracking.web.dto;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.entity.GPSDeviceInfo;
import com.example.locationtracking.entity.MobileAppInfo;
import com.example.locationtracking.entity.TrackingInfo;
import org.springframework.util.StringUtils;

public class AssetUpdateInfoDTO {

    private String assetId;

    private String driverName;

    private DeviceType deviceType;

    private AssetTrackingConfigDTO trackingConfig;

    public void updateAssetEntity(Assets assetEntity){
        if(!StringUtils.isEmpty(this.driverName)){
            assetEntity.setDriverName(this.driverName);
        }
        if(this.deviceType != null){
            assetEntity.setDeviceType(this.deviceType);
            TrackingInfo trackingInfo = null;
            if(DeviceType.MOBILE.equals(this.deviceType)){
                if(this.trackingConfig.getPhoneNumber() == null || this.trackingConfig.getUserName() == null){
                    throw new RuntimeException(
                            " phone number and user name is mandatory if you are trying to update device type as mobile");
                }
                trackingInfo = new MobileAppInfo(this.trackingConfig.getPhoneNumber(), this.trackingConfig.getUserName());
            }
            else if(DeviceType.GPS_DEVICE.equals(this.deviceType)){
                if(this.trackingConfig.getDeviceId() == null || this.trackingConfig.getManufacturer() == null){
                    throw new RuntimeException(
                            " Device Id and manufacturer is mandatory if you are trying to update device type as GPS");
                }
                trackingInfo = new GPSDeviceInfo(this.trackingConfig.getDeviceId(), this.trackingConfig.getManufacturer());
            }
            trackingInfo.setTrackFromTime(this.trackingConfig.getTrackFromTime());
            trackingInfo.setTrackToTime(this.trackingConfig.getTrackToTime());
            trackingInfo.setTrackingFrequency(this.trackingConfig.getTrackingFrequency());
            assetEntity.setTrackingInfo(trackingInfo);
        }
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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

    public AssetTrackingConfigDTO getTrackingConfig() {
        return trackingConfig;
    }

    public void setTrackingConfig(AssetTrackingConfigDTO trackingConfig) {
        this.trackingConfig = trackingConfig;
    }
}
