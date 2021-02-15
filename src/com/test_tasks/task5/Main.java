package com.test_tasks.task5;


import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] wordArray={
                "apple","orange","fish","box","robot","apple",
                "cat","orange","fish","wall","apple","apple",
                "human","array","word"
        };
        HashMap<String,Integer> wordMap = new HashMap<String,Integer>();
        for(String word :wordArray){
            if(!wordMap.containsKey(word)){
                wordMap.put(word,1);
            }
            else{
                wordMap.put(word,wordMap.get(word)+1);
            }
        }
        System.out.println(wordMap.keySet());
        Phonebook phonebook = new Phonebook();
        phonebook.add("bank","8 800 555 35 35");
        phonebook.add("eshli","8 800 365 48 95");
        phonebook.add("bobi","8 845 555 35 45");
        phonebook.add("jon","8 800 555 35 45");
        phonebook.add("bank","8 800 555 56 35");
        System.out.println( phonebook.get("bank"));
    }
}
