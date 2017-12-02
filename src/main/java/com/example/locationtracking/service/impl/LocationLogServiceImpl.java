package com.example.locationtracking.service.impl;

import com.example.locationtracking.entity.AssetLocationLog;
import com.example.locationtracking.repository.LocationLogRepository;
import com.example.locationtracking.service.LocationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationLogServiceImpl implements LocationLogService {

    @Autowired
    private LocationLogRepository locationLogRepository;

    @Override
    public void logLocation(AssetLocationLog locationLog) {
        locationLogRepository.insert(locationLog);
    }
}
