package com.lozano.showcase.healthcheck_mock_service.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping(value = "/mockService")
public class BasicDummyHealthAPIs {

    @GetMapping
    @RequestMapping(value = "/blue")
    public ResponseEntity getHealthBlue(){
        log.info("BasicDummyHealthAPIs - getHealthBlue called successfully");
        return ResponseEntity.ok("healthy");
    }

    @GetMapping
    @RequestMapping(value = "/red")
    public ResponseEntity getHealthRed(@RequestParam String id){
        if (StringUtils.hasLength(id)){
            if (!id.equalsIgnoreCase("1234")){
                return ResponseEntity.badRequest().build();
            }
        }
        log.info("BasicDummyHealthAPIs - getHealthRed called successfully");
        return ResponseEntity.ok("healthy");
    }

    @GetMapping
    @RequestMapping(value = "/green")
    public ResponseEntity getHealthGreen(@RequestHeader("my-custom-header") String myCustomHeader){
        if (StringUtils.hasLength(myCustomHeader)){
            if (!myCustomHeader.equalsIgnoreCase("hookEmHorns")){
                return ResponseEntity.badRequest().build();
            }
        }
        log.info("BasicDummyHealthAPIs - getHealthGreen called successfully");
        return ResponseEntity.ok("healthy");
    }
}
