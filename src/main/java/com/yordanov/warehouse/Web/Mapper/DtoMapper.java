package com.yordanov.warehouse.Web.Mapper;

import com.yordanov.warehouse.Web.Dto.ProductResponse;
import lombok.experimental.UtilityClass;
import com.yordanov.warehouse.Product.Model.Product;

import java.util.List;

@UtilityClass
public class DtoMapper {

    public static ProductResponse toProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .sku(product.getSku())
                .description(product.getDescription())
                .build();
    }

    public static List<ProductResponse> toProductResponseList(List<Product> products) {
        return products.stream().map(DtoMapper::toProductResponse).toList();
    }

}
