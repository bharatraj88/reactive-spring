package com.example.locationtracking.service.impl;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.repository.AssetsRepository;
import com.example.locationtracking.service.AssetManagementService;
import com.example.locationtracking.web.dto.AssetDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AssetManagementServiceImpl implements AssetManagementService{

    @Autowired
    private AssetsRepository assetsRepository;

    /**
     * Adds a new Asset
     * @param assetDTO
     * @return
     */
    @Override
    public String addNewAsset(AssetDTO assetDTO){
        Assets entity = assetsRepository.insert(assetDTO.toEntity());
        return entity.getId();
    }

    /**
     * Removes an Asset from the db permanently
     * @param assetId
     */
    @Override
    public void removeAsset(String assetId){
        assetsRepository.deleteById(assetId);
    }

    /**
     * Returns an Asset identified by Id
     * @param assetId
     * @return
     */
    @Override
    public Optional<Assets> getAssetById(String assetId){
        return assetsRepository.findById(assetId);
    }

    /**
     * Returns All sets
     * @return
     */
    @Override
    public List<Assets> findAllAssets(){
        return assetsRepository.findAll();
    }

    /**
     * Returns All Assets by device Id
     * @param deviceType
     * @return
     */
    @Override
    public List<Assets> findAllAssets(DeviceType deviceType){
        return  assetsRepository.findByDeviceType(deviceType);
    }

}
