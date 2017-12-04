package com.example.locationtracking.service.impl;

import com.example.locationtracking.entity.AssetLocationLog;
import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.repository.AssetsRepository;
import com.example.locationtracking.repository.LocationLogRepository;
import com.example.locationtracking.service.LocationLogService;
import com.example.locationtracking.web.dto.LocationLogRequestDTO;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationLogServiceImpl implements LocationLogService {

    @Autowired
    private LocationLogRepository locationLogRepository;

    @Autowired
    private AssetsRepository assetsRepository;

    @Override
    public void logLocation(LocationLogRequestDTO locationLogRequestDTO) {
        AssetLocationLog locationLog = locationLogRequestDTO.toEntity();
        Optional<Assets> assets = assetsRepository.findById(locationLogRequestDTO.getAssetId());
        if(!assets.isPresent()){
            throw new RuntimeException(" Invalid Assets Id");
        }
        locationLog.setDeviceType(assets.get().getDeviceType());
        locationLog.setDriverName(assets.get().getDriverName());
        locationLogRepository.insert(locationLog);
    }

}
