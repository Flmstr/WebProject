package com.ExcelWeb.dao;

import com.ExcelWeb.models.TypeWork;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ExcelWeb.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TypeWorkDao {

    public TypeWork findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TypeWork.class, id);
    }

    public void save(TypeWork typeWork){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(typeWork);
        tx1.commit();
        session.close();
    }
    public void update(TypeWork typeWork){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(typeWork);
        tx1.commit();
        session.close();
    }
    public void delete(TypeWork typeWork){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(typeWork);
        tx1.commit();
        session.close();
    }

    public List<TypeWork> findAll() {
        List<TypeWork> typeWork = (List<TypeWork>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TypeWork").list();
        for (TypeWork type : typeWork){
            type.setName(type.getName().trim());
        }
        return typeWork;
    }

    public List<TypeWork> findSample(String term){
        term = term.toLowerCase();
        return (List<TypeWork>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TypeWork tw WHERE lower(tw.name) like '%"+ term + "%' ").setMaxResults(10).list();
    }
}

