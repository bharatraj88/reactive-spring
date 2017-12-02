package com.example.locationtracking.web;

import com.example.locationtracking.service.LocationLogService;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/location")
public class LocationRequestController {

    @Autowired
    private LocationLogService locationLogService;

    @RequestMapping(method = RequestMethod.POST , value = "/log")
    Mono<String> logLocation() {
        return Mono.fromCompletionStage(CompletableFuture.supplyAsync(() -> {
            //locationLogService.logLocation();
            return "SUCCESS";
        }));
    }

}
