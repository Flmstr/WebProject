package com.ExcelWeb.utils;

import com.ExcelWeb.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateSessionFactoryUtil {

    @Autowired
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Position.class);
                configuration.addAnnotatedClass(EmployeesName.class);
                configuration.addAnnotatedClass(TypeWork.class);
                configuration.addAnnotatedClass(Addresses.class);
                configuration.addAnnotatedClass(Users.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e){
                System.out.println("Исключение: " + e);
            }

        }
        return sessionFactory;
    }
}
