package com.yordanov.warehouse.Web.ProductController;

import com.yordanov.warehouse.Product.Model.Product;
import com.yordanov.warehouse.Product.Service.ProductService;
import com.yordanov.warehouse.Web.Dto.ProductRequest;
import com.yordanov.warehouse.Web.Dto.ProductResponse;
import com.yordanov.warehouse.Web.Mapper.DtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){

        Product product = productService.createNewProduct(productRequest);
        ProductResponse productResponse = DtoMapper.toProductResponse(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);

    }
}
