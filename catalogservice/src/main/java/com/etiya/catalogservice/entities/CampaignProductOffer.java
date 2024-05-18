package com.etiya.catalogservice.entities;

import com.etiya.catalogservice.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "deleted_date IS NULL")
@Table(name = "campaign_product_offers")
public class CampaignProductOffer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "productOffer_id")
    private ProductOffer productOffer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;
}
