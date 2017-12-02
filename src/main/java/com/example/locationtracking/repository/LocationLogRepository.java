package com.example.locationtracking.repository;

import com.example.locationtracking.entity.AssetLocationLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationLogRepository extends MongoRepository<AssetLocationLog,String> {
}
