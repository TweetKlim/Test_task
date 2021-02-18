package com.testtask.task13;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<Product>();
        for(int i = 0; i < 5; ++i)
        {
            productList.add(new Product(new Long(i+1),""+i,i));
        }
    }
    public void printAll(){
        for(Product product : productList) {
            System.out.println(product.getId() +" "+ product.getTitle() +" "+ product.getCost());
        }
    }
    public Product findByTitle(String title){
        for(Product product : productList) {
            if(product.getTitle().equals(title)){
                return  product;
            }
        }
        return null;
    }
}
