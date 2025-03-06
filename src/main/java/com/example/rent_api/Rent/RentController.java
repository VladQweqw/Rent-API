package com.example.rent_api.Rent;

import com.example.rent_api.Utility.Utility;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/rent")
@AllArgsConstructor
public class RentController {

    private final RentService rentService;

    @GetMapping(path = "{id}")
    public Rent get_by_id(
            @PathVariable("id") String id
    ) {
        return rentService.get_by_id(id);
    }

    @PostMapping
    public Rent create_rent(
            @RequestBody RentRequest rent
    ) {
        return rentService.create_rent(rent);
    }

    @PutMapping(path = "{id}")
    public Rent update_rent(
            @PathVariable("id") String id,
            @RequestBody RentRequest rent
    ) {
        return rentService.update_rent(id, rent);
    }

    @PutMapping(path = "{id}/utilities")
    public Rent add_utility_to_rent(
            @PathVariable("id") String rent_id,
            @RequestBody Utility utility
    ) {
        return rentService.add_utility_to_rent(rent_id, utility);
    }


    @DeleteMapping(path = "{id}")
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
