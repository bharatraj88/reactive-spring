package com.example.locationtracking.service;

import com.example.locationtracking.web.dto.LocationLogRequestDTO;

public interface LocationLogService {

    void logLocation(LocationLogRequestDTO locationLog);
}
