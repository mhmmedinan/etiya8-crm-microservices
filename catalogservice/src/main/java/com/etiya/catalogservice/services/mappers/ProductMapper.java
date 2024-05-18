package com.etiya.catalogservice.services.mappers;

import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiya.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiya.catalogservice.services.dtos.responses.productResponses.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    GetAllProductResponse getAllProductResponseFromProduct(Product product);
    Product productFromCreateProductRequest(CreateProductRequest createProductRequest);
    CreatedProductResponse createdProductResponseFromProduct(Product product);
    Product productFromUpdateProductRequest(UpdateProductRequest updateProductRequest);
    UpdatedProductResponse updatedProductResponseFromProduct(Product product);
    DeletedProductResponse deletedProductResponseFromProduct(Product product);
    GetProductResponse getProductResponseFromProduct(Product product);
}
