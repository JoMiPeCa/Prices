package com.inditex.prices.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name="PRICES")
@AllArgsConstructor
public class PricesModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private Integer brandId;

    @Column(nullable = false)
    private Timestamp startDate;

    @Column(nullable = false)
    private Timestamp endDate;

    @Column(nullable = false)
    private Integer priceList;

    @Column(nullable = false)
    private Integer productId;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, name = "curr")
    private String currency;

}
