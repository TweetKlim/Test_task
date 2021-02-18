package com.testtask.task11;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Order> orders;
    Product(String name, double price)
    {
        this.name = name;
    }
    @Override
    public String toString(){
        return "Product" + id + " " + name + " " + price;
    }
    int getId()
    {
        return id;
    }
    String getName()
    {
        return name;
    }

    void setName(String name)
    {
        this.name = name;
    }
    double getPrice()
    {
        return price;
    }

    void setPrice(double price)
    {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
