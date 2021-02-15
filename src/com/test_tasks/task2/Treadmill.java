package com.test_tasks.task2;

public class Treadmill implements Obstacle {
    private int distance;
    Treadmill(int distance){
        if(distance < 0)
        {
            System.out.println("Дистанция не может быть отрицательной");
            return;
        }
        this.distance = distance;
    }
    @Override
    public boolean contest(Participant participant){
        if (participant.run(distance))
        {
            System.out.println("Дистанция успешно преодолена");
            return true;
        }
        System.out.println("Участник не смог преодолеть дистанцию(выбывает из соревнования)");
        return false;
    }
}
