package com.generali.burritoorderingservice.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "extra")
@Table(name = "extras")
public class Extras {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "extra_type")
    private String extraType;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;
}
