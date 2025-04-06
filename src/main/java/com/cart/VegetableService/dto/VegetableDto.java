package com.cart.VegetableService.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VegetableDto(
        @NotNull(message = "Name must not be null")
        @Size(min =2)
        String name,
        @NotNull(message = "category must not be null")
        @Min(0)
        @Max(4)
        Integer category,
        double availableQuantity) {
}
