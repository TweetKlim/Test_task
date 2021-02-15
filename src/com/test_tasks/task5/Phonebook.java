package com.test_tasks.task5;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {

    private HashMap<String, ArrayList<String>> book = new HashMap<>();

    public void add(String name,String phone){
        if(!book.containsKey(name)){
            book.put(name, new ArrayList<>());
        }
        book.get(name).add(phone);
    }
    public String get(String name){
        if(book.containsKey(name))
        {
            return book.get(name).toString();
        }
        return "Такой человек отсутствует";
    }
}
