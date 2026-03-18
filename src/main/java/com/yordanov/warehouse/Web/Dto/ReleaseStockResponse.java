package com.yordanov.warehouse.Web.Dto;

import com.yordanov.warehouse.InventoryMovement.Model.ReferenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseStockResponse {

    private UUID movementId;

    private UUID warehouseId;

    private UUID productId;

    private int releaseQuantity;

    private String reference;

    private ReferenceType referenceType;

    private LocalDateTime releaseAt;
}
