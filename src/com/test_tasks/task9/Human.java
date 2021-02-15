package com.test_tasks.task9;

@Table(title = "Human")
public class Human {
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private int salary;

    Human(String name, int age, int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
