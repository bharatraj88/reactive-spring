package com.example.locationtracking.service.impl;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.repository.AssetsRepository;
import com.example.locationtracking.service.AssetManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetManagementServiceImpl implements AssetManagementService{

    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    public void addNewAsset(Assets asset){
        assetsRepository.insert(asset);
    }

    @Override
    public void removeAsset(String assetId){
        assetsRepository.deleteById(assetId);
    }
}
