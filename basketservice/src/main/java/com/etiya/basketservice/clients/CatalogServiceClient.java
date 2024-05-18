package com.etiya.basketservice.clients;

import com.etiya.basketservice.services.dtos.responses.GetCatalogProductOfferResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url ="http://localhost:8001/",value = "catalog-service")//gateway gelince catalog-service eklenecek
public interface CatalogServiceClient {


    @RequestMapping(method = RequestMethod.GET,value = "catalog-service/api/v1/catalogproductoffers/{id}")
    GetCatalogProductOfferResponse getById(@PathVariable String id);
}
