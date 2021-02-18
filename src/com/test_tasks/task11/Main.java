package com.testtask.task11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderKey.class)
                .buildSessionFactory();
        Session session = null;

        try{
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                System.out.print("enter command: ");
                String command = scanner.nextLine();
                String[] commandSplit = command.split( " ");
                if(command.equals("exit")){
                    break;
                }
                Person person;
                Product product;
                switch (commandSplit[0]){
                    case "/showProductsByPerson":
                        session = factory.getCurrentSession();
                        session.beginTransaction();
                        person = (Person) session.createQuery("FROM Person p WHERE p.name= :name")
                                .setParameter("name", commandSplit[1]);
                        List<Order> orders = person.getOrders();
                        orders.forEach(o ->
                        System.out.println("product of" + person.getName() + " " + o.getProduct().getName()));
                        session.getTransaction().commit();
                        break;
                    case "/findPersonsByProductTitle":
                        session = factory.getCurrentSession();
                        session.beginTransaction();
                        product = (Product) session.createQuery("FROM Product p WHERE p.name= :name")
                                .setParameter("name", commandSplit[1]);
                        orders = product.getOrders();
                        orders.forEach(o ->
                                System.out.println("person of" + product.getName() + " " + o.getProduct().getName()));
                        session.getTransaction().commit();
                        break;
                    case "/removePerson":
                        session = factory.getCurrentSession();
                        session.beginTransaction();
                        person = (Person) session.createQuery("FROM Person p WHERE p.name= :name")
                                .setParameter("name", commandSplit[1]);

                        session.delete(person);
                        System.out.println(person.getName() + " deleted");
                        session.getTransaction().commit();
                        break;
                    case "/removeProduct":
                        session = factory.getCurrentSession();
                        session.beginTransaction();
                        product = (Product) session.createQuery("FROM Product p WHERE p.name= :name")
                                .setParameter("name", commandSplit[1]);

                        session.delete(product);
                        System.out.println(product.getName() + " deleted");
                        session.getTransaction().commit();
                        break;
                    case "/buy":
                        session = factory.getCurrentSession();
                        session.beginTransaction();
                        person = (Person) session.createQuery("FROM Person p WHERE p.name= :name")
                                .setParameter("name", commandSplit[1]);
                        product = (Product) session.createQuery("FROM Product p WHERE p.name= :name")
                                .setParameter("name", commandSplit[1]);

                        OrderKey orderKey = new OrderKey(person.getId(),product.getId());
                        Order order = new Order(orderKey,product.getPrice());

                        session.save(order);
                        session.getTransaction().commit();
                        System.out.print(person.getName() + " buy " + product.getName());
                        break;
                    default:
                        break;
                }
            }
        }finally {
            factory.close();
            if(session != null){
                session.close();

            }
        }
    }
}
