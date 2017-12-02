package com.example.locationtracking.service;

import com.example.locationtracking.entity.Assets;

public interface AssetManagementService {

    void addNewAsset(Assets asset);

    void removeAsset(String assetId);
}
