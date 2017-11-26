package reactivespring.example.locationtracking.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/location")
public class LocationRequestController {

    @RequestMapping("/log")
    @ResponseBody
    Mono<String> logLocation() {
        return Mono.just("App Started");
    }

}
