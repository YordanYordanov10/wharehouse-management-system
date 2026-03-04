package com.yordanov.warehouse.Web.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.UUID;

@Data
public class ReceiveStockRequest {

    @NotBlank
    private UUID productId;

    @NotBlank
    private UUID warehouseId;

    @NotBlank
    @Positive(message = "Price must be positive number")
    private int quantity;

    @NotBlank
    private String reference;
}
