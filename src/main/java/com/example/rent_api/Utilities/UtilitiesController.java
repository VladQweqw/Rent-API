package com.example.rent_api.Utilities;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/utilities")
@AllArgsConstructor
public class UtilitiesController {
    private final UtilitiesService utilitiesService;

    @GetMapping(path = "{id}")
    public Utilities get_by_id(
            @PathVariable("id") String id
    ) {
        return utilitiesService.get_by_id(id);
    }

    @PostMapping()
    public Utilities create_utilities(
            @RequestBody UtilitiesRequest utilities
    ) {
        return utilitiesService.create_utiltiies(utilities);
    }

    @GetMapping("check")
    public String check() {
        return this.utilitiesService.check();
    }
}
