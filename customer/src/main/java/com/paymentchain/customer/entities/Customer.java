package com.paymentchain.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Customer {


    @GeneratedValue(strategy = GenerationType.AUTO) //Esto va ahcer que que "id" sea autoincremental
    @Id
    private long id;
    private String name;
    private int phone;



}
