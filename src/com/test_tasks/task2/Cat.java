package com.test_tasks.task2;

public class Cat implements Participant {
    private int maxRunDistance;
    private int maxJumpHeight;
    Cat(int maxRunDistance,int maxJumpHeight)
    {
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean run(int distace) {
        if(distace <= maxRunDistance){
            System.out.println("Кот бежит");
            return true;
        }
        System.out.println("Кот не может пробежать так много");
        return false;
    }

    @Override
    public boolean jump(int height) {
        if(height <= maxJumpHeight){
            System.out.println("Кот прыгает");
            return true;
        }
        System.out.println("Кот не может прыгнуть так высоко");
        return false;

    }

}
