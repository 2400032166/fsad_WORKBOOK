package com.inventory.app;

import org.hibernate.Session;

import com.inventory.util.HibernateUtil;

public class HQLAggregates {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Long totalProducts =
            (Long) session.createQuery(
                "select count(*) from Product").uniqueResult();

        Long availableProducts =
            (Long) session.createQuery(
                "select count(*) from Product where quantity > 0").uniqueResult();

        Object[] minMaxPrice =
            (Object[]) session.createQuery(
                "select min(price), max(price) from Product").uniqueResult();

        System.out.println("Total products: " + totalProducts);
        System.out.println("Available products (quantity > 0): " + availableProducts);
        System.out.println("Minimum price: " + minMaxPrice[0]);
        System.out.println("Maximum price: " + minMaxPrice[1]);

        session.close();
    }
}
