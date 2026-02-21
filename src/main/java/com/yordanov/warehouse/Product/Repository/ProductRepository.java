package com.yordanov.warehouse.Product.Repository;

import com.yordanov.warehouse.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {


}
