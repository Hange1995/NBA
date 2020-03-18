package com.hardworking.training.repository;

import com.hardworking.training.model.Player;
import com.hardworking.training.model.Position;
import com.hardworking.training.util.HibernateUtil;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PositionDaoImpl implements PositionDao {
    private Logger logger = LoggerFactory.getLogger(PositionDao.class);

    @Override
    public Position save(Position position) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(position);
            transaction.commit();
            session.close();
            return position;
        } catch (Exception e) {
            if (transaction!= null) transaction.rollback();
            logger.error("failure to save the data",e);
            session.close();
        } return position;
    }


    @Override
    public boolean delete(Position position) {
        String hql = "DELETE Position as position where position.positionName = :position_name";
        int deletedCount=0;
        Transaction transaction =null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Player> query= session.createQuery(hql);
            query.setParameter("position_name",position.getPositionName());
            deletedCount=query.executeUpdate();
            transaction.commit();
            session.close();
            return deletedCount>1 ?true :false;
        }catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            session.close();
            logger.error("failure to delete data",e);
        }return false;

    }

    @Override
    public Position getPositionEagerBy(Long id) {
        String hql = "FROM Position p LEFT JOIN FETCH p.player WHERE p.id=:Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Position> query = session.createQuery(hql);
            query.setParameter("Id",id);
            Position result = query.uniqueResult();
            session.close();
            return result;
        }catch (HibernateException e){
            logger.error("failure to retrieve data record",e);
            return null;
        }
    }

    @Override
    public Position getPositionBy(Long id) {
        return null;
    }
}
