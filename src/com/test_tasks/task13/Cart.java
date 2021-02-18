package com.testtask.task13;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@CompositeValue.Component
public class Cart {
    private List<Product> productList;

    @PostConstruct
    public void init()
    {
        productList = new ArrayList<>();
    }

    public void add(Product product){
        productList.add(product);
    }
    public List<Product> getProductList(){
        return productList;
    }

}
