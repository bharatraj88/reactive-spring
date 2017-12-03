package com.example.locationtracking.service.impl;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.repository.AssetsRepository;
import com.example.locationtracking.service.AssetManagementService;
import com.example.locationtracking.web.dto.AssetUpdateInfoDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetManagementServiceImpl implements AssetManagementService{

    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    public String addNewAsset(Assets asset){
        assetsRepository.insert(asset);
        return asset.getId();
    }

    @Override
    public void removeAsset(String assetId){
        assetsRepository.deleteById(assetId);
    }

    @Override
    public void updateAssetInfo(AssetUpdateInfoDTO assetUpdateInfoDTO) {
        Optional<Assets> assetsOptional = assetsRepository.findById(assetUpdateInfoDTO.getAssetId());
        if(!assetsOptional.isPresent()){
            throw new RuntimeException(" Invalid asset Id "+ assetUpdateInfoDTO.getAssetId());
        }
        Assets asset = assetsOptional.get();
        assetUpdateInfoDTO.updateAssetEntity(asset);
        assetsRepository.save(asset);
    }
}
