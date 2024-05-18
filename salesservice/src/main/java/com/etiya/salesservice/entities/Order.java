package com.etiya.salesservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Order {

    private String id;
    private String customerId;
    private double totalPrice;
    private List<OrderItem> orderItems;

    //Address sınıfı oluşuturp customerservice tarafından gelen
    // address bilgisini burda ki address alanlarına setleyeceğiz.

    public Order(){
        this.orderItems=new ArrayList<>();
    }
}
