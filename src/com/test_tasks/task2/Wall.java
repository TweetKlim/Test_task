package com.test_tasks.task2;

public class Wall implements Obstacle {
    private int height;
    Wall(int height){
        if(height < 0)
        {
            System.out.println("Высота не может быть отрицательной");
            return;
        }
        this.height = height;
    }
    @Override
    public boolean contest(Participant participant){
        if (participant.jump(height))
        {
            System.out.println("Высота успешно преодолена");
           return true;
        }
        System.out.println("Участник не смог преодолеть высоту(выбывает из соревнования)");
        return false;
    }
}
