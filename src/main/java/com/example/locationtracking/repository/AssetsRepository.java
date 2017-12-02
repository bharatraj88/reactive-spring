package com.example.locationtracking.repository;

import com.example.locationtracking.entity.Assets;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetsRepository extends MongoRepository<Assets, String> {

}
