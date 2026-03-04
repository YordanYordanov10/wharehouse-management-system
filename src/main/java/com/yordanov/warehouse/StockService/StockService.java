package com.yordanov.warehouse.StockService;

import com.yordanov.warehouse.Exception.ResourceNotFoundException;
import com.yordanov.warehouse.Inventory.Model.Inventory;
import com.yordanov.warehouse.Inventory.Repository.InventoryRepository;
import com.yordanov.warehouse.InventoryMovement.Model.InventoryMovement;
import com.yordanov.warehouse.InventoryMovement.Model.MovementType;
import com.yordanov.warehouse.InventoryMovement.Model.ReferenceType;
import com.yordanov.warehouse.InventoryMovement.Repository.InventoryMovementRepository;
import com.yordanov.warehouse.Product.Model.Product;
import com.yordanov.warehouse.Product.Repository.ProductRepository;
import com.yordanov.warehouse.Warehouse.Model.Warehouse;
import com.yordanov.warehouse.Warehouse.Repository.WarehouseRepository;
import com.yordanov.warehouse.Web.Dto.ReceiveStockRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StockService {

    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final InventoryRepository inventoryRepository;
    private final InventoryMovementRepository inventoryMovementRepository;

    public StockService(ProductRepository productRepository, WarehouseRepository warehouseRepository, InventoryRepository inventoryRepository, InventoryMovementRepository inventoryMovementRepository) {
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.inventoryRepository = inventoryRepository;
        this.inventoryMovementRepository = inventoryMovementRepository;
    }

    @Transactional
    public InventoryMovement receiveStock(ReceiveStockRequest receiveStockRequest) {

       Product product = productRepository.findById(receiveStockRequest.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
       Warehouse warehouse = warehouseRepository.findById(receiveStockRequest.getWarehouseId()).orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));

       Optional<Inventory> optionalInventory = inventoryRepository.findByWarehouseIdAndProductId(warehouse.getId(),product.getId());

        if(optionalInventory.isPresent()){
            Inventory inventory = optionalInventory.get();
            inventory.setQuantity(inventory.getQuantity() + receiveStockRequest.getQuantity());
            inventory.setUpdatedAt(LocalDateTime.now());

            inventoryRepository.save(inventory);
        }else{
            Inventory inventory = Inventory.builder()
                    .product(product)
                    .warehouse(warehouse)
                    .quantity(receiveStockRequest.getQuantity())
                    .updatedAt(LocalDateTime.now())
                    .build();

            inventoryRepository.save(inventory);
        }

        InventoryMovement inventoryMovement =InventoryMovement.builder()
                .movementType(MovementType.IN)
                .reference(receiveStockRequest.getReference())
                .referenceType(ReferenceType.DELIVERY)
                .createdAt(LocalDateTime.now())
                .quantity(receiveStockRequest.getQuantity())
                .product(product)
                .warehouse(warehouse)
                .build();

        inventoryMovementRepository.save(inventoryMovement);

        return inventoryMovement;
    }
}
