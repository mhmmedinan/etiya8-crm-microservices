package com.etiyacrm.customerservice.entities;


import com.etiyacrm.customerservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted_date IS NULL")
public class Address extends BaseEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="description")
    private String description;

    @Column(name = "street")
    private String street;

    @Column(name = "flatNumber")
    private int flatNumber;

    @Column(name = "defaultAddress")
    private boolean defaultAddress;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}