package com.assignment.com.registration.assignment.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
    private BigDecimal total_amount;

}
