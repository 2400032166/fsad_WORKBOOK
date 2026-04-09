package com.inventory.app;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.util.HibernateUtil;

public class HQLGroupBy {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Object[]> query =
            session.createQuery(
                "select description, count(*) from Product group by description");

        System.out.println("Products grouped by description:");
        for (Object[] row : query.list()) {
            System.out.println(row[0] + " -> " + row[1]);
        }

        session.close();
    }
}
