package com.cart.VegetableService.service;

import com.cart.VegetableService.dao.VegetableRepository;
import com.cart.VegetableService.dto.VegetableDto;
import com.cart.VegetableService.entity.Vegetable;
import com.cart.VegetableService.entity.VegetableCategory;
import com.cart.VegetableService.exception.VegetableNotFoundException;
import com.cart.VegetableService.serviceImpl.VegetableServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class VegetableServiceTest {

    @Mock
    private VegetableRepository vegetableRepository;

    @InjectMocks
    private VegetableServiceImpl vegetableService;

    @Test
    void saveTest() {
        VegetableDto vegetableDto =
                new VegetableDto("Tomato", VegetableCategory.fruit.ordinal(), 0);
        Vegetable vegetable = new Vegetable();
        vegetable.setName("Tomato");
        vegetable.setCategory(VegetableCategory.fruit);
        vegetable.setAvailableQuantity(0d);
        when(vegetableRepository.saveAndFlush(vegetable)).thenReturn(vegetable);
        vegetableService.save(vegetableDto);

        verify(vegetableRepository, times(1)).saveAndFlush(vegetable);
    }

    @Test
    void findTest1(){
        Vegetable vegetable = new Vegetable();
        vegetable.setName("Tomato");
        vegetable.setCategory(VegetableCategory.fruit);
        vegetable.setAvailableQuantity(0d);

        when(vegetableRepository.findById(1l)).thenReturn(Optional.of(vegetable));

        VegetableDto vegetableDto1 = vegetableService.find(1l);
        assertEquals(vegetable.getName(),vegetableDto1.name());
        verify(vegetableRepository,times(1)).findById(1l);
    }

    @Test
    void findTest2(){
        Vegetable vegetable = new Vegetable();
        vegetable.setName("Tomato");
        vegetable.setCategory(VegetableCategory.fruit);
        vegetable.setAvailableQuantity(0d);

        when(vegetableRepository.findById(1l)).thenReturn(Optional.empty());

        Exception ex = assertThrows(VegetableNotFoundException.class,()->{
            vegetableService.find(1l);
        });
        assertTrue(ex.getMessage().contains("Not Found with id: "));
        verify(vegetableRepository,times(1)).findById(1l);
    }


}