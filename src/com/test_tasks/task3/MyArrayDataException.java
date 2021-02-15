package com.test_tasks.task3;

public class MyArrayDataException extends RuntimeException{

    public MyArrayDataException(int row, int coloumn) {
        super("Ошибка данных в [строке:" + row + ",стоблце:" + coloumn + "]");
    }
}
