package com.inventory.app;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class HQLSortByQuantity {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> query =
                session.createQuery("from Product order by quantity desc", Product.class);

        List<Product> list = query.list();

        System.out.println("Products sorted by quantity (Highest first):");
        list.forEach(p ->
            System.out.println(p.getName() + " - " + p.getQuantity())
        );

        session.close();
    }
}
