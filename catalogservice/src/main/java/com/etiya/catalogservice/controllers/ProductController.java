package com.etiya.catalogservice.controllers;

import com.etiya.catalogservice.services.abstracts.ProductService;
import com.etiya.catalogservice.services.dtos.requests.productRequests.CreateProductRequest;
import com.etiya.catalogservice.services.dtos.requests.productRequests.UpdateProductRequest;
import com.etiya.catalogservice.services.dtos.responses.productResponses.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedProductResponse add(@Valid @RequestBody CreateProductRequest createProductRequest){
        return productService.add(createProductRequest);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedProductResponse update(@Valid @RequestBody UpdateProductRequest updateProductRequest, @PathVariable String id) {
        return productService.update(updateProductRequest, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.OK)
    public DeletedProductResponse delete(@PathVariable String id) {
        return productService.delete(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getAll")
    public List<GetAllProductResponse> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "getById")
    public GetProductResponse getById(@PathVariable String id) {
        return productService.getById(id);
    }
}
