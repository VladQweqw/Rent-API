package com.example.rent_api.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping(path = "{id}")
    public Utility get_utility_by_id(
            @PathVariable("id") String id
    ) {
        return utilityService.get_utility_by_id(id);
    }

    @PutMapping(path = "{id}")
    public Utility update_utility(
            @PathVariable("id") String id,
            @RequestBody Utility updated
    ) {
        return utilityService.update_utility(id, updated);
    }

    @PostMapping()
    public Utility create_utility(
            @RequestBody Utility utility
    ) {
        return utilityService.create_utility(utility);
    }
}
