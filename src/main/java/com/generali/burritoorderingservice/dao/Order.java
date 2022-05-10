package com.generali.burritoorderingservice.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "order")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "tortilla_type")
    private String tortilla;

    @NotNull
    @Column(name = "protein_type")
    private String protein;

    @NotNull
    @Column(name = "salsa_type")
    private String salsa;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Vegetables> vegetables = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Extras> extras = new ArrayList<>();
}
