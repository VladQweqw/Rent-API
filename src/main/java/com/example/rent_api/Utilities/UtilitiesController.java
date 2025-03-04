package com.example.rent_api.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/utilities")
public class UtilitiesController {
    private final UtilitiesService utilitiesService;

    @Autowired
    public UtilitiesController(UtilitiesService utilitiesService) {
        this.utilitiesService = utilitiesService;
    }

    @GetMapping(path = "{id}")
    public Utilities get_by_id(
            @PathVariable("id") String id
    ) {
        return utilitiesService.get_by_id(id);
    }

    @PostMapping()
    public Utilities create_utilities(
            @RequestBody Utilities utilities
    ) {
        return utilitiesService.create_utiltiies(utilities);
    }

    @GetMapping("check")
    public String check() {
        return this.utilitiesService.check();
    }
}
