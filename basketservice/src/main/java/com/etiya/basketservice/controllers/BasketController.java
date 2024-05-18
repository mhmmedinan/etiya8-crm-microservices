package com.etiya.basketservice.controllers;

import com.etiya.basketservice.services.abstracts.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/basket")
public class BasketController {
    private BasketService basketService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam String customerId, @RequestParam String productOfferId){
        basketService.add(customerId, productOfferId);
    }
}
