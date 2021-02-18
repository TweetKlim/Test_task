package com.testtask.task13;

public class Product {
    private Long id;

    private String title;

    private int cost;

    public Product(Long id, String title, int cost){
        this.id = id;
        this.cost = cost;
        this.title = title;
    }

    Long getId()
    {
        return id;
    }
    String getTitle(){
        return title;
    }
    double getCost(){
        return cost;
    }
    void setId(Long id){
        this.id = id;
    }

    void setTitle(String title){
        this.title = title;
    }

    void setCost(int cost){
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return id + " " + title + " " + cost;
    }

}
