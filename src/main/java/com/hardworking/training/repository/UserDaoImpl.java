package com.hardworking.training.repository;

import com.github.fluent.hibernate.H;
import com.hardworking.training.model.User;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public User save(User user) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
            return user;
        }catch (Exception e){
            if (transaction==null) transaction.rollback();
            logger.error("failure to save the user",e);
            session.close();
            return null;
        }
    }

    @Override
    public List<User> getUsers() {
        String hql="FROM User";
        Transaction transaction=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = new ArrayList<>();
        try {
            transaction=session.beginTransaction();
            Query<User> query = session.createQuery(hql);
            users=query.list();
            transaction.commit();
            session.close();
            return users;
        }catch (Exception e){
            if (transaction==null) transaction.rollback();
            logger.error("Failure to get User list",e);
            session.close();
            return null;
        }
    }

    @Override
    public boolean delete(String name) {
        String hql ="Delete User as u where u.name =:name";
        int deleteCount=0;
        Transaction transaction=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction=session.beginTransaction();
            Query<User> query = session.createQuery(hql);
            query.setParameter("name",name);
            deleteCount=query.executeUpdate();
            transaction.commit();
            session.close();
            return deleteCount>=1 ? true: false;
        }catch (Exception e){
            if (transaction==null)  transaction.rollback();
            logger.error("Failure to delete User by name",e );
            session.close();
            return false;
        }
    }

    @Override
    public User update(User user) {
        Transaction transaction =null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction=session.beginTransaction();
            session.update(user);
            transaction.commit();
            session.close();
            return user;
        }catch (Exception e){
            if (transaction==null) transaction.rollback();
            logger.error("failure to update user");
            session.close();
            return null;
        }
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }
}
