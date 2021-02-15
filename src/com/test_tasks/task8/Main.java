package com.test_tasks.task8;


import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {



    public static void main(String[] args) {
        String[] wordArray={
                "apple","orange","fish","box","robot","apple",
                "cat","orange","fish","wall","apple","apple",
                "human","array","word"
        };
        String word = Arrays.stream(wordArray)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(e -> e.getValue()))
                .get().getKey();
        System.out.println(word);
        Human[] humans = {new Human("joe",20,1000),
                new Human("miki",25,12300),
                new Human("mouse", 40,15432),
                new Human("tom", 35,1432)};

       OptionalDouble average =  Arrays.stream(humans)
                .mapToDouble(Human::getSalary)
                .average();
        System.out.println(average);
        int n = 2;
        String olds = Arrays.stream(humans)
                .sorted((h1,h2)-> h2.getAge() - h1.getAge())
                .limit(n)
                .map(Human::getName)
                .collect(Collectors.joining(", ", n + " самых старших сотрудников зовут ", "."));
        System.out.println(olds);
    }

}
