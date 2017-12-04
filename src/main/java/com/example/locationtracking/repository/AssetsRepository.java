package com.example.locationtracking.repository;

import com.example.locationtracking.entity.Assets;
import com.example.locationtracking.entity.DeviceType;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AssetsRepository extends MongoRepository<Assets, String> {

    @Query("{deviceType : ?0}")
    public List<Assets> findByDeviceType(DeviceType deviceType);
}
