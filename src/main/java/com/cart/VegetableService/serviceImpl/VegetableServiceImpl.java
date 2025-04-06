package com.cart.VegetableService.serviceImpl;

import com.cart.VegetableService.dao.VegetableRepository;
import com.cart.VegetableService.dto.VegetableDto;
import com.cart.VegetableService.entity.Vegetable;
import com.cart.VegetableService.entity.VegetableCategory;
import com.cart.VegetableService.exception.VegetableNotFoundException;
import com.cart.VegetableService.service.VegetableService;
import org.springframework.stereotype.Service;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public void save(VegetableDto vegetableDto) {
        Vegetable vegetable = new Vegetable();
        vegetable.setName(vegetableDto.name());
        vegetable.setCategory(VegetableCategory.values()[vegetableDto.category()]);
        vegetable.setAvailableQuantity(vegetableDto.availableQuantity());
        vegetableRepository.saveAndFlush(vegetable);
    }

    @Override
    public VegetableDto find(long vegetableId) {
        Vegetable vegetable = vegetableRepository.findById(vegetableId).
                orElseThrow(()-> new VegetableNotFoundException("Not Found with id: "+vegetableId));
        return convertToDto(vegetable);
    }

    @Override
    public VegetableDto find(String vegetableName) {
        return null;
    }

    @Override
    public VegetableDto find() {
        return null;
    }

    @Override
    public VegetableDto update(VegetableDto vegetableDto) {
        return null;
    }

    private VegetableDto convertToDto(Vegetable vegetable){
        return new VegetableDto(
                vegetable.getName(), vegetable.getCategory().ordinal(),
                vegetable.getAvailableQuantity());
    }
}
