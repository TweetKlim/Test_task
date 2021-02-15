package com.test_tasks.task2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Participant> participants = new ArrayList<Participant>();
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

        participants.add(new Cat(10,3));
        participants.add(new Human(100,5));
        participants.add(new Robot(50,10));

        obstacles.add(new Wall(1));
        obstacles.add(new Treadmill(20));
        obstacles.add(new Treadmill(50));
        obstacles.add(new Wall(5));
        obstacles.add(new Wall(10));

        for(Participant participant : participants)
        {
            for(Obstacle obstacle: obstacles)
            {
                if(!obstacle.contest(participant))
                {
                    break;
                }
            }
        }
    }
}
