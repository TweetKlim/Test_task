package com.test_tasks.task7;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore semaphore;
    public Tunnel(int carCount) {
        this.semaphore = new Semaphore(carCount/2);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            if(!semaphore.tryAcquire()){
                System.out.println(c.getName() + " готовится к этапу(ждет): " +
                        description);
                semaphore.acquire();
            }
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            System.out.println(c.getName() + " закончил этап: " +
                    description);
            semaphore.release();
        }
    }
}

