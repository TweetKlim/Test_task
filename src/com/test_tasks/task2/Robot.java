package com.test_tasks.task2;

public class Robot implements Participant {
    private int maxRunDistance;
    private int maxJumpHeight;
    Robot(int maxRunDistance,int maxJumpHeight)
    {
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean run(int distace) {
        if(distace <= maxRunDistance){
            System.out.println("Робот бежит");
            return true;
        }
        System.out.println("Робот не может пробежать так много");
        return false;
    }

    @Override
    public boolean jump(int height) {
        if(height <= maxJumpHeight){
            System.out.println("Робот прыгает");
            return true;
        }
        System.out.println("Робот не может прыгнуть так высоко");
        return false;

    }
}
