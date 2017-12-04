package com.example.locationtracking.service;

import com.example.locationtracking.web.dto.AssetUpdateInfoDTO;

public interface AssetDriverLinkageService {

    void linkDriverToAsset(AssetUpdateInfoDTO assetUpdateInfoDTO);

    void deLinkDriverFromAsset(String id);
}
