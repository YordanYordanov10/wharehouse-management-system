package com.yordanov.warehouse.InventoryMovement.Repository;

import com.yordanov.warehouse.InventoryMovement.Model.InventoryMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InventoryMovementRepository extends JpaRepository<InventoryMovement, UUID> {
}
