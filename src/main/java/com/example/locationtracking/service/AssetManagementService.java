package com.example.locationtracking.service;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceType;
import com.example.locationtracking.web.dto.AssetDTO;
import com.example.locationtracking.web.dto.AssetUpdateInfoDTO;
import java.util.List;
import java.util.Optional;

public interface AssetManagementService {

    String addNewAsset(AssetDTO assetDTO);

    void removeAsset(String assetId);

    Optional<Assets> getAssetById(String assetId);

    List<Assets> findAllAssets();

    List<Assets> findAllAssets(DeviceType deviceType);
}
