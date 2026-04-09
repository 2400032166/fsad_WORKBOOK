package com.inventory.app;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class HQLSortByPrice {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> ascQuery =
                session.createQuery("from Product order by price asc", Product.class);
        List<Product> ascList = ascQuery.list();

        System.out.println("Products sorted by price (Ascending):");
        ascList.forEach(p -> 
            System.out.println(p.getName() + " - " + p.getPrice())
        );

        Query<Product> descQuery =
                session.createQuery("from Product order by price desc", Product.class);
        List<Product> descList = descQuery.list();

        System.out.println("\nProducts sorted by price (Descending):");
        descList.forEach(p -> 
            System.out.println(p.getName() + " - " + p.getPrice())
        );

        session.close();
    }
}
