package com.hardworking.training.repository;

import com.github.fluent.hibernate.H;
import com.hardworking.training.model.Role;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao{

    @Override
    public Role save(Role role) {
        Transaction transaction=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try {
            transaction= session.beginTransaction();
            session.save(role);
            transaction.commit();
            session.close();
            return role;
        }catch (HibernateException e){
            if (transaction!=null) transaction.rollback();
            System.out.println("Save failed");
            session.close();
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        String hql="DELETE Role as r where r.id=:id";
        int deleteCount=0;
        Transaction transaction=null;
        Session session =HibernateUtil.getSessionFactory().openSession();
        try {
            transaction=session.beginTransaction();
            Query<Role> query= session.createQuery(hql);
            query.setParameter("id", id);
            deleteCount=query.executeUpdate();
            transaction.commit();
            session.close();
            return deleteCount>=1 ?true :false;
        }catch (HibernateException e){
            if (transaction!=null) transaction.rollback();
            System.out.println("Delete role failed");
            session.close();
            return false;
        }
    }

    @Override
    public Role getRoleByName(String name) {
        String hql="FROM Role as r where r.name=:name";
        Transaction transaction= null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try {
            transaction=session.beginTransaction();
            Query<Role> query=session.createQuery(hql);
            query.setParameter("name",name);
            Role role=query.uniqueResult();
            transaction.commit();
            session.close();
            return role;
        }catch (HibernateException h){
            if (transaction!=null) transaction.rollback();
            System.out.println("Can't get role by name");
            session.close();
            return null;
        }
    }


}
