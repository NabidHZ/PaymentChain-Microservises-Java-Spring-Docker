package com.paymentchain.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


@Entity
public class Customer {

    @Data
    @GeneratedValue(strategy = GenerationType.AUTO) //Esto va ahcer que que "id" sea autoincremental
    private long id;
    private String name;
    private int phone;



}
