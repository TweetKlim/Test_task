package com.testtask.task13;

public class Main {

    public static void main(String[] args){
        ProductService productService = context.getBean("productservice", ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);
        OrderService orderService = context.getBean("orderservice", OrderService.class);

        cart.add(productService.findByTitle("5"));
        cart.add(productService.findByTitle("3"));
        cart.add(productService.findByTitle("2"));

        orderService.createOrder(cart.getProductList());
    }

}
