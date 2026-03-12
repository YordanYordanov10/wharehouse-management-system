package com.yordanov.warehouse.Web;

import com.yordanov.warehouse.Inventory.Service.InventoryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


}
