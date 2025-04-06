package com.cart.VegetableService.service;

import com.cart.VegetableService.dto.VegetableDto;

public interface VegetableService {

    void save(VegetableDto vegetableDto);

    VegetableDto find(long vegetableId);

    VegetableDto find(String vegetableName);

    VegetableDto find();

    VegetableDto update(VegetableDto vegetableDto);
}
