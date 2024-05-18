package com.etiya.catalogservice.services.concretes;

import com.etiya.catalogservice.entities.Product;
import com.etiya.catalogservice.repositories.ProductRepository;
import com.etiya.catalogservice.services.abstracts.ProductService;
import com.etiya.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiya.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiya.catalogservice.services.dtos.responses.productResponses.*;
import com.etiya.catalogservice.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public CreatedProductResponse add(CreateProductRequest createProductRequest) {
        Product product = ProductMapper.INSTANCE.productFromCreateProductRequest(createProductRequest);

        Product createdProduct = productRepository.save(product);

        CreatedProductResponse createdProductResponse =
                ProductMapper.INSTANCE.createdProductResponseFromProduct(createdProduct);

        return createdProductResponse;
    }

    @Override
    public UpdatedProductResponse update(UpdateProductRequest updateProductRequest, String id) {
        //rule
        Product product = ProductMapper.INSTANCE.productFromUpdateProductRequest(updateProductRequest);
        product.setId(id);
        product.setUpdatedDate(LocalDateTime.now());

        Product updatedProduct = productRepository.save(product);

        UpdatedProductResponse updatedProductResponse =
                ProductMapper.INSTANCE.updatedProductResponseFromProduct(updatedProduct);

        return updatedProductResponse;
    }

    @Override
    public DeletedProductResponse delete(String id) {
        //rule
        Product product = productRepository.findById(id).get();
        product.setId(id);
        product.setDeletedDate(LocalDateTime.now());

        Product deletedProduct = productRepository.save(product);

        DeletedProductResponse deletedProductResponse =
                ProductMapper.INSTANCE.deletedProductResponseFromProduct(deletedProduct);

        return deletedProductResponse;
    }

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> productList = productRepository.findAll();

        List<GetAllProductResponse> getAllProductResponseList =
                productList.stream().map(ProductMapper.INSTANCE::getAllProductResponseFromProduct)
                        .collect(Collectors.toList());

        return getAllProductResponseList;
    }

    @Override
    public GetProductResponse getById(String id) {
        Product product = productRepository.findById(id).get();

        GetProductResponse getProductResponse =
                ProductMapper.INSTANCE.getProductResponseFromProduct(product);

        return getProductResponse;
    }
}
