package com.yordanov.warehouse.Web.ProductController;

import com.yordanov.warehouse.Product.Model.Product;
import com.yordanov.warehouse.Product.Service.ProductService;
import com.yordanov.warehouse.Web.Dto.ProductRequest;
import com.yordanov.warehouse.Web.Dto.ProductResponse;
import com.yordanov.warehouse.Web.Mapper.DtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {

        List<Product> products = productService.findAllProducts();
        List<ProductResponse> productResponses = DtoMapper.toProductResponseList(products);
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @PostMapping("/product")
    ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){

        Product product = productService.addProduct(productRequest);
        ProductResponse productResponse = DtoMapper.toProductResponse(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);

    }

    @GetMapping("/product/{id}")
    ResponseEntity<ProductResponse> getProduct(@PathVariable UUID id) {

        Product product = productService.getProductById(id);
        ProductResponse productResponse = DtoMapper.toProductResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @PutMapping("/product/{id}")
    ResponseEntity<ProductResponse> updateProduct(@PathVariable UUID id, @RequestBody ProductRequest productRequest) {

        Product product = productService.updateProductById(id,productRequest);
        ProductResponse productResponse = DtoMapper.toProductResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @DeleteMapping("/product/{id}")
    ResponseEntity<ProductResponse> deleteProduct(@PathVariable UUID id) {

       productService.deleteProductById(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
