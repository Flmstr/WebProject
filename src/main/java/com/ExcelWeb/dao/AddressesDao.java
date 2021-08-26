package com.ExcelWeb.dao;

import com.ExcelWeb.models.Addresses;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.ExcelWeb.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class AddressesDao {

    public Addresses findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Addresses.class, id);
    }

    public void save(Addresses addresses){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(addresses);
        tx1.commit();
        session.close();
    }
    public void update(Addresses addresses){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(addresses);
        tx1.commit();
        session.close();
    }
    public void delete(Addresses addresses){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(addresses);
        tx1.commit();
        session.close();
    }

    public List<Addresses> findAll() {
        List<Addresses> addresses = (List<Addresses>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Addresses").list();
        return addresses;
    }

    public List<Addresses> findSampleUnique(String term){
        term = term.toLowerCase();
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Addresses a WHERE lower(a.organization) like '%"+ term + "%' ");
        query.setMaxResults(10);
        return (List<Addresses>) query.list();
    }

    public List<Addresses> findSample(String term, String company){
        term = term.toLowerCase();
        company = company.toLowerCase();
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Addresses a WHERE lower(a.shortaddress) like '%"+ term
                + "%' and lower(a.organization) = '"+ company +"' ");
        query.setMaxResults(10);
        return (List<Addresses>) query.list();
    }
}

