package com.inventory.app;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class HQLPriceRange {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> query =
            session.createQuery(
                "from Product where price between 5000 and 30000",
                Product.class
            );

        System.out.println("Products in price range 5000 to 30000:");
        for (Product p : query.list()) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        session.close();
    }
}
