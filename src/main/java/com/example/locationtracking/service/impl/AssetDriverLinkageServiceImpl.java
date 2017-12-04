package com.example.locationtracking.service.impl;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.repository.AssetsRepository;
import com.example.locationtracking.service.AssetDriverLinkageService;
import com.example.locationtracking.web.dto.AssetUpdateInfoDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AssetDriverLinkageServiceImpl implements AssetDriverLinkageService {

    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    public void linkDriverToAsset(AssetUpdateInfoDTO assetUpdateInfoDTO) {
        if(assetUpdateInfoDTO == null || assetUpdateInfoDTO.getAssetId() == null){
            throw new RuntimeException(" Asset Id Not present");
        }
        Optional<Assets> assetsOptional = this.assetsRepository.findById(assetUpdateInfoDTO.getAssetId());
        if(!assetsOptional.isPresent()){
            throw new RuntimeException(String.format(" Invalid Asset Id : %s",assetUpdateInfoDTO.getAssetId()));
        }
        if(!StringUtils.isEmpty(assetsOptional.get().getDriverName())){
            throw new RuntimeException(" Driver Already linked to Asset. De Link first to proceed");
        }
        Assets asset = assetsOptional.get();
        assetUpdateInfoDTO.updateAssetEntity(asset);
        assetsRepository.save(asset);
    }

    @Override
    public void deLinkDriverFromAsset(String id) {
        Optional<Assets> assetsOptional = this.assetsRepository.findById(id);
        if(!assetsOptional.isPresent()){
            throw new RuntimeException(" Invalid Asset Id");
        }
        Assets asset = assetsOptional.get();
        asset.setDriverName(null);
        if(DeviceType.MOBILE.equals(asset.getDeviceType())){
            asset.setTrackingInfo(null);
        }
        this.assetsRepository.save(asset);
    }
}
