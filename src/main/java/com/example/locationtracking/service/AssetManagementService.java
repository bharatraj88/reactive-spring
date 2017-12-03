package com.example.locationtracking.service;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.web.dto.AssetUpdateInfoDTO;

public interface AssetManagementService {

    String addNewAsset(Assets asset);

    void removeAsset(String assetId);

    void updateAssetInfo(AssetUpdateInfoDTO assetUpdateInfoDTO);
}
