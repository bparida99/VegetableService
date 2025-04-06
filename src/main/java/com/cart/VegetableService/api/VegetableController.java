package com.cart.VegetableService.api;
import com.cart.VegetableService.dto.VegetableDto;
import com.cart.VegetableService.service.VegetableService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody VegetableDto vegetableDto){
        vegetableService.save(vegetableDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public VegetableDto find(@PathVariable long id){
        return vegetableService.find(id);
    }
}
