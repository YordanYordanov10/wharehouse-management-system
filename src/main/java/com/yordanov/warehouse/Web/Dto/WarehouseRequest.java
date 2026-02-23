package com.yordanov.warehouse.Web.Dto;

import com.yordanov.warehouse.Warehouse.Model.WarehouseStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class WarehouseRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Warehouse code is required")
    private String warehouseCode;

    @NotBlank
    @Size(max = 200)
    private String address;

    @NotBlank
    @Size(max = 100)
    private String city;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String country;

    @NotBlank
    private int maxPalletCapacity;

    @NotBlank
    private WarehouseStatus status;




}
