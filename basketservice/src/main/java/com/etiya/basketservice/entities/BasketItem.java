package com.etiya.basketservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "basket-items")
public class BasketItem {
    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "productOfferId")
    private String productOfferId;

    @Field(name = "productOfferName")
    private String productOfferName;

    @Field(name = "price")
    private double price;

    @Field(name = "campaignId")
    private String campaignId;

}
