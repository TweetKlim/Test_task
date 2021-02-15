package com.test_tasks.task3;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
        super("Ошибка размера массива(не 4x4)");
    }
}
