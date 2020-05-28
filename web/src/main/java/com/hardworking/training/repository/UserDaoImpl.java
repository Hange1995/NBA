package com.hardworking.training.repository;


import com.hardworking.training.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository("True")
public class UserDaoImpl implements UserDao{
    private Logger logger = LoggerFactory.getLogger(UserDao.class);
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public User save(User user) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
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
        String hql ="FROM User u where (lower(u.email) = :name or lower(u.name) =:name)";
        logger.debug("User Id"+name);
        try (Session session=sessionFactory.openSession()){
            Query<User> query=  session.createQuery(hql);
            query.setParameter("name",name.toLowerCase().trim());
//            User user=query.uniqueResult();
            return query.uniqueResult();
        }catch (Exception e){
            logger.info("can't get by name");
            return null;
        }
    }



    @Override
    public User getUserById(Long id) {
        String hql ="FROM User user where user.id=:Id";
        logger.debug("User Id"+id);
        try (Session session=sessionFactory.openSession()){
            Query<User> query=  session.createQuery(hql);
            query.setParameter("Id",id);
//            User user=query.uniqueResult();
            return query.uniqueResult();
        }catch (Exception e){
            logger.info("can't get by id");
            return null;
        }
    }
    @Override
    public User getUserByCredentials(String email, String password) throws Exception {
        String hql = "FROM User as u where (lower(u.email) = :email or lower(u.name) =:email) and u.password = :password";
        logger.debug(String.format("User email: %s, password: %s", email, password));
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery(hql);
            query.setParameter("email", email.toLowerCase().trim());
            query.setParameter("password", password);
            User user=query.uniqueResult();
            return user;
        }
        catch (Exception e){
            throw new Exception("can't find user record or session");
        }
    }

}
