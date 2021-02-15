package com.test_tasks.task4;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(new Apple());
        Box<Apple> appleBox1 = new Box<>(new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange());

        if(appleBox.compare(appleBox1))
            System.out.println("равны");
        else
            System.out.println("не равны");
        appleBox1.transfer(appleBox);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());
        System.out.println(orangeBox.getWeight());
        if(appleBox.compare(orangeBox))
            System.out.println("равны");
        else
            System.out.println("не равны");
        orangeBox.add(new Orange());
        appleBox.add(new Apple());
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        if(appleBox.compare(orangeBox))
            System.out.println("равны");
        else
            System.out.println("не равны");
    }
    private static void swap(Object [] array, int first,int second){
        Object t = array[first];
        array[first] = array[second];
        array[second] = t;
    }
    private static <T> ArrayList<T> array2List(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
