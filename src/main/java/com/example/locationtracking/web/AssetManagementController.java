package com.example.locationtracking.web;

import com.example.locationtracking.nonreactive.service.AssetManagementService;
import com.example.locationtracking.web.dto.AssetDTO;

import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/asset")
public class AssetManagementController {

    @Autowired
    private AssetManagementService assetManagementService;

    @RequestMapping(method = RequestMethod.PUT)
    public Mono<String> addAsset(@RequestBody AssetDTO assetDTO){
        return Mono.fromCompletionStage(CompletableFuture.supplyAsync(() -> {
            return assetManagementService.addNewAsset(assetDTO);
        }).thenApplyAsync((assetId) -> {
            System.out.println(" Send Request to Device Id -> "+assetId);
            return "REQUESTED";
        }));
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/{id}")
    public Mono<String> removeAsset(@RequestAttribute String id){
        return Mono.fromCompletionStage(CompletableFuture.supplyAsync(() -> {
            assetManagementService.removeAsset(id);
            return "SUCCESS";
        }));
    }

}
