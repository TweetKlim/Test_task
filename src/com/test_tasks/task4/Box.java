package com.test_tasks.task4;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> container;

    public Box(){
        this.container = new ArrayList<>();
    }
    public Box(T... fruits){
        this.container = new ArrayList<>(Arrays.asList(fruits));
    }
    public void add(T... fruits) {
        this.container.addAll(Arrays.asList(fruits));
    }
    public void add(ArrayList<T> fruits) {
        this.container.addAll(fruits);
    }
    public float getWeight(){
        if(container.size() == 0){
            return 0.0f;
        }
        return container.size() * container.get(0).getWeight();
    }
    public boolean compare(Box<?> otherBox){
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.4f;
    }
    public void transfer(Box<T> otherBox){
        if(this != otherBox) {
            otherBox.add(this.container);
            this.container.clear();
        }
    }
}
