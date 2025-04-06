package com.cart.VegetableService.api;

import com.cart.VegetableService.dto.VegetableDto;
import com.cart.VegetableService.entity.VegetableCategory;
import com.cart.VegetableService.serviceImpl.VegetableServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VegetableController.class)
public class VegetableControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private VegetableServiceImpl vegetableService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveTest1() throws Exception {
        VegetableDto vegetableDto =
                new VegetableDto("Tomato", VegetableCategory.fruit.ordinal(), 0);
        Mockito.doNothing().when(vegetableService).save(vegetableDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vegetable/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vegetableDto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void saveTest2() throws Exception {
        VegetableDto vegetableDto =
                new VegetableDto("Tomato", 6, 0);
        Mockito.doNothing().when(vegetableService).save(vegetableDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vegetable/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vegetableDto)))
                        .andExpect(status().isBadRequest());
    }
}
