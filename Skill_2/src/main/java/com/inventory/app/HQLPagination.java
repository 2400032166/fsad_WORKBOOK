package com.inventory.app;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class HQLPagination {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> query =
                session.createQuery("from Product", Product.class);

        // First 3 products
        query.setFirstResult(0);
        query.setMaxResults(3);

        System.out.println("First 3 products:");
        query.list().forEach(p ->
            System.out.println(p.getName())
        );

        // Next 3 products
        query.setFirstResult(3);
        query.setMaxResults(3);

        System.out.println("\nNext 3 products:");
        query.list().forEach(p ->
            System.out.println(p.getName())
        );

        session.close();
    }
}
