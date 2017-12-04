package com.example.locationtracking.service.impl;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.repository.AssetsRepository;
import com.example.locationtracking.service.AssetManagementService;
import com.example.locationtracking.web.dto.AssetDTO;
import com.example.locationtracking.web.dto.AssetUpdateInfoDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetManagementServiceImpl implements AssetManagementService{

    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    public String addNewAsset(AssetDTO assetDTO){
        Assets entity = assetsRepository.insert(assetDTO.toEntity());
        return entity.getId();
    }

    @Override
    public void removeAsset(String assetId){
        assetsRepository.deleteById(assetId);
    }

    @Override
    public Optional<Assets> getAssetById(String assetId){
        return assetsRepository.findById(assetId);
    }

}
