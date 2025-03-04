package com.example.rent_api.Rent;

import com.example.rent_api.Utilities.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rent")
public class RentController {

    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping(name = "{id}")
    public Rent get_by_id(
            @PathVariable("id") String id
    ) {
        return rentService.get_by_id(id);
    }

    @PostMapping
    public Rent create_rent(
            @RequestBody Rent rent
    ) {
        return rentService.create_rent(rent);
    }

    @PutMapping(name = "{id}")
    public Rent update_rent(
            @PathVariable("id") String id,
            @RequestBody Rent rent
    ) {
        return rentService.update_rent(id, rent);
    }


    @DeleteMapping(name = "{id}")
    public void delete_rent(
            @PathVariable("id") String id
    ) {
        rentService.delete_rent(id);
    }

    @GetMapping("check")
    public String check() {
        return this.rentService.check();
    }
}
