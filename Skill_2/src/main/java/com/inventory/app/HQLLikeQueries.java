package com.inventory.app;

import org.hibernate.Session;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class HQLLikeQueries {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println("Names starting with 'P':");
        session.createQuery(
                "from Product where name like 'P%'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("\nNames ending with 'r':");
        session.createQuery(
                "from Product where name like '%r'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("\nNames containing 'tab':");
        session.createQuery(
                "from Product where name like '%tab%'", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));

        System.out.println("\nNames with exact length 5:");
        session.createQuery(
                "from Product where length(name)=5", Product.class)
                .list()
                .forEach(p -> System.out.println(p.getName()));

        session.close();
    }
}
