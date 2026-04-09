package com.inventory.app;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class InsertMoreProducts {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Monitor", "Electronics", 12000, 15));
        session.save(new Product("Printer", "Electronics", 15000, 5));
        session.save(new Product("Tablet", "Electronics", 30000, 8));
        session.save(new Product("Desk", "Furniture", 9000, 20));
        session.save(new Product("Chair", "Furniture", 4500, 25));
        session.save(new Product("Pen", "Stationery", 20, 100));
        session.save(new Product("Notebook", "Stationery", 80, 60));

        tx.commit();
        session.close();

        System.out.println("Additional products inserted");
    }
}
