package com.bytenest.InventoryApi.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PartRecordDto(@NotBlank String name,
                            @NotNull BigDecimal value,
                            @NotBlank String codeSku,
                            @NotBlank String description,
                            @NotNull Integer quantity,
                            @NotBlank String entryDate,
                            @NotBlank String supplier) {
}
