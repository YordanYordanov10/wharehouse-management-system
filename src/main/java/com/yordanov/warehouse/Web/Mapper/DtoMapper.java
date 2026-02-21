package com.yordanov.warehouse.Web.Mapper;

import com.yordanov.warehouse.Web.Dto.ProductResponse;
import lombok.experimental.UtilityClass;
import com.yordanov.warehouse.Product.Model.Product;

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

}
