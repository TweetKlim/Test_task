package com.testtask.task13;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    public void createOrder(List<Product> productList){
        int sum = 0;
        for(Product product: productList){
            System.out.println(product.toString());
            sum += product.getCost();
        }
        System.out.println("Sum = " + sum);

    }
}
