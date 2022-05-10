package com.generali.burritoorderingservice.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "vegetable")
@Table(name = "vegetables")
public class Vegetables {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "vegetable_type")
    private String vegetableType;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
