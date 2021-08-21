package com.example.ThymeleafComputer.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "computer")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Computer {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "c_computerId")
    private int computerId;

    @Column(name = "c_overview")
    private String overview;

    @Column(name = "c_systemComponents")
    private String systemComponents;

    @Column(name = "c_price")
    private double price;

}
