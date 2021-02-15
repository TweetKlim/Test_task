package com.test_tasks.task2;

public class Human implements Participant {
    private int maxRunDistance;
    private int maxJumpHeight;
    Human(int maxRunDistance,int maxJumpHeight)
    {
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean run(int distace) {
        if(distace <= maxRunDistance){
            System.out.println("Человек бежит");
            return true;
        }
        System.out.println("Человек не может пробежать так много");
        return false;
    }

    @Override
    public boolean jump(int height) {
        if(height <= maxJumpHeight){
            System.out.println("Человек прыгает");
            return true;
        }
        System.out.println("Человек не может прыгнуть так высоко");
        return false;

    }
}
