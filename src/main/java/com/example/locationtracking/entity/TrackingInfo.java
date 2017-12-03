package com.example.locationtracking.entity;

import java.time.LocalTime;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class TrackingInfo {

    private LocalTime trackFromTime;

    private LocalTime trackToTime;

    private LocalTime trackingFrequency;

    public LocalTime getTrackFromTime() {
        return trackFromTime;
    }

    public void setTrackFromTime(LocalTime trackFromTime) {
        this.trackFromTime = trackFromTime;
    }

    public LocalTime getTrackToTime() {
        return trackToTime;
    }

    public void setTrackToTime(LocalTime trackToTime) {
        this.trackToTime = trackToTime;
    }

    public LocalTime getTrackingFrequency() {
        return trackingFrequency;
    }

    public void setTrackingFrequency(LocalTime trackingFrequency) {
        this.trackingFrequency = trackingFrequency;
    }
}
