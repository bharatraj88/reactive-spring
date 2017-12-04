package com.example.locationtracking.web.dto;

import com.example.locationtracking.entity.DeviceType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDateTime;

public class LocationLogDTO {

    @JsonFormat(shape = Shape.STRING,  pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime logTime;

    private String location;

    private DeviceType deviceType;

    private Long speed;

    private String additionalData;

}
