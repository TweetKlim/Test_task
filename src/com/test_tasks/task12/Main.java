package com.testtask.task12;

import com.testtask.task11.Order;
import com.testtask.task11.OrderKey;
import com.testtask.task11.Person;
import com.testtask.task11.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.OptimisticLockException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    static final int TREAD_NUMBER = 8;
    public static void main(String[] args) throws IOException{
        SessionFactory factory = new Configuration()
                .configure("hibernate.ofg.xml")
                .buildSessionFactory();
        Session session = null;
        try{
            String sql = Files.lines(Paths.get("task12.sql"))
                    .collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        }finally {
            factory.close();
            if(session != null)
            {
                session.close();
            }
        }
        long startTime = System.currentTimeMillis();
        threads(TREAD_NUMBER);
        System.out.println("time " + (System.currentTimeMillis()- startTime));
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Object o = session.createQuery("SELECT SUM(val) FROM items");
        }finally {
            factory.close();
            if(session != null)
            {
                session.close();
            }
        }
    }
    private static void threads(int threadsNum)
    {
        CountDownLatch countDownLatch = new CountDownLatch(threadsNum);
        Thread[] threads = new Thread[threadsNum];

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.ofg.xml")
                .buildSessionFactory()){
            ;
            for (int i = 0; i < threadsNum; ++i){
                threads[i] = new Thread(()-> {

                    for(int j = 0; j < 20000;++j){
                        boolean hasCommit = false;
                        long random = (long) (Math.random() * 39) + 1;
                        Session session = factory.getCurrentSession();
                        session.beginTransaction();
                        Item item = session.get(Item.class, random);
                        item.setVal(item.getVal() + 1);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            session.save(item);
                            session.getTransaction().commit();
                            hasCommit = true;
                        }catch(OptimisticLockException e){
                            session.getTransaction().rollback();
                        }
                        session.close();
                        if(!hasCommit)
                        {
                            --j;
                        }
                    }
                    countDownLatch.countDown();
                });
                threads[i].start();
            }try {
                countDownLatch.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
