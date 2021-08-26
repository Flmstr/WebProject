package com.ExcelWeb.dao;

import com.ExcelWeb.models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.ExcelWeb.utils.HibernateSessionFactoryUtil;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDao {

    @PersistenceContext
    private SessionFactory sessionFactory;

    public Users findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Users.class, id);
    }


    @SuppressWarnings("unchecked")
    public Users findByUserName(String userName) {

        List<Users> users = new ArrayList<Users>();

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        users = session
                .createQuery("from Users where username=:userName")
                .setParameter("userName", userName)
                .list();

        tx1.commit();
        session.close();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    public void save(Users users){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(users);
        tx1.commit();
        session.close();
    }
    public void update(Users users){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(users);
        tx1.commit();
        session.close();
    }
    public void delete(Users users){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(users);
        tx1.commit();
        session.close();
    }

    public List<Users> findAll() {
        List<Users> users = (List<Users>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Users").list();
        for (Users type : users){
            type.setUsername(type.getUsername().trim());
        }
        return users;
    }
}

