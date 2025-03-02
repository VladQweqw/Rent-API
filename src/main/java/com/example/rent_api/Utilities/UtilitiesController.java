package com.example.rent_api.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/utilities")
public class UtilitiesController {
    private final UtilitiesService utilitiesService;

    @Autowired
    public UtilitiesController(UtilitiesService utilitiesService) {
        this.utilitiesService = utilitiesService;
    }

    @GetMapping("check")
    public String check() {
        return this.utilitiesService.check();
    }
}
