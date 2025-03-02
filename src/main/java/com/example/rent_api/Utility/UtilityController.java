package com.example.rent_api.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/utility")
public class UtilityController {
    private final UtilityService utilityService;

    @Autowired
    UtilityController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("check")
    public String check_route() {
        return utilityService.check();
    }
}
