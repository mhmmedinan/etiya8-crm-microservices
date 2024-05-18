package com.etiya.salesservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_characteristic_value")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCharacteristicValue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "value")
    private String value;

    @Column(name = "productId")
    private String productId;

    @Column(name = "characteristicId")
    private String characteristicId;

    @Column(name = "characteristicValueId")
    private String characteristicValueId;
}
