package com.hardworking.training.repository;


import com.hardworking.training.model.User;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository("True")
public class UserDaoImpl implements UserDao{
    private Logger logger = LoggerFactory.getLogger(UserDao.class);
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
        String hql ="FROM User user where user.name=:Name";
        logger.debug("User Id"+name);
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            Query<User> query=  session.createQuery(hql);
            query.setParameter("Name",name);
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
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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

//    @Override
//    public Set<Role> getRoles(String name) {
//            if (name==null)return null;
//            String hql =
//                    "FROM User as u "+
//                            "join fetch u.users_roles as ur "+
//                            "join fetch ur.role as r "+
//                            "Where lower(u.name)=:name";
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            try {
//                Query query = session.createQuery(hql);
//                query.setParameter("name",name.toLowerCase());
////            HashSet<Team> result = query.getResultList();
////            Set<Team> listResult = new ArrayList<>();
//                List<Role> result = query.getResultList();
//                Set<Role> setResult = result.stream().collect(Collectors.toSet());
//                session.close();
//                return setResult;
//            }catch (HibernateException e){
//                logger.error("can not get both",e);
//                return null;
//            }
//        }
}
