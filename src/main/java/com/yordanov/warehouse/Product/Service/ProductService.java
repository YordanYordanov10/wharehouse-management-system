package com.yordanov.warehouse.Product.Service;

import com.yordanov.warehouse.Product.Model.Product;
import com.yordanov.warehouse.Product.Repository.ProductRepository;
import com.yordanov.warehouse.Web.Dto.ProductRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createNewProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .sku(productRequest.getSku())
                .build();

         productRepository.save(product);

         return product;
    }
}
