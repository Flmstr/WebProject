package com.ExcelWeb.dao;

import com.ExcelWeb.models.EmployeesName;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ExcelWeb.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeesNameDao {

    public EmployeesName findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(EmployeesName.class, id);
    }

    public void save(EmployeesName employeesName){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(employeesName);
        tx1.commit();
        session.close();
    }
    public void update(EmployeesName employeesName){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(employeesName);
        tx1.commit();
        session.close();
    }
    public void delete(EmployeesName employeesName){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(employeesName);
        tx1.commit();
        session.close();
    }

    public List<EmployeesName> findAll() {
        return (List<EmployeesName>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EmployeesName").list();
    }

    public List<EmployeesName> findSample(String term){
        term = term.toLowerCase();
        return (List<EmployeesName>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From EmployeesName en WHERE lower(en.name) like '%"+ term + "%' ").setMaxResults(10).list();
    }
}

