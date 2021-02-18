package com.testtask.task11;


import javax.persistence.*;

@Entity
@Table(name = "person_product")
public class Order {
    @EmbeddedId
    private OrderKey orderKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", insertable =  false, updatable = false)
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable =  false, updatable = false)
    private Product product;

    @Column(name = "price")
    private double price;

    Order(OrderKey orderKey, double price)
    {
        this.orderKey = orderKey;
        this.price = price;
    }

    Product getProduct(){
        return product;
    }
}
