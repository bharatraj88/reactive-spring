package com.example.locationtracking.web;

import com.example.locationtracking.nonreactive.service.AssetDriverLinkageService;
import com.example.locationtracking.web.dto.AssetUpdateInfoDTO;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/asset/driver")
public class AssetDriverLinkageController {

    @Autowired
    private AssetDriverLinkageService linkDriverToAsset;

    @RequestMapping(method = RequestMethod.POST , value = "link")
    public Mono<String> linkDriverToAsset(@RequestBody AssetUpdateInfoDTO assetUpdateInfoDTO){
        return Mono.fromCompletionStage(CompletableFuture.supplyAsync(() -> {
            linkDriverToAsset.linkDriverToAsset(assetUpdateInfoDTO);
            return assetUpdateInfoDTO.getAssetId();
        }).thenApplyAsync((assetId) -> {
            return "REQUESTED";
        }));
    }

    @RequestMapping(method = RequestMethod.POST , value = "delink/{id}")
    public Mono<String> deLinkDriverFromAsset(@RequestAttribute String id){
        return Mono.fromCompletionStage(CompletableFuture.supplyAsync(() -> {
            linkDriverToAsset.deLinkDriverFromAsset(id);
            return "COMPLETED";
        }));
    }
}
