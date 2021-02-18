package com.testtask.task11;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Order> orders;
    Person(String name)
    {
        this.name = name;
    }
    @Override
    public String toString(){
        return "Person" + id + " " + name + " ";
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

    public List<Order> getOrders() {
        return orders;
    }
}
