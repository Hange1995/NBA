package com.hardworking.training.repository;

import com.hardworking.training.model.Player;
import com.hardworking.training.model.Position;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.HibernateException;
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
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PositionDaoImpl implements PositionDao {
    private Logger logger = LoggerFactory.getLogger(PositionDao.class);
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Position save(Position position) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
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
        } return null;
    }


    @Override
    public boolean delete(String positionName) {
        String hql = "DELETE Position as pos where lower(pos.positionName) = :name";
        int deletedCount = 0;
        Transaction transaction =null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query<Position> query= session.createQuery(hql);
            query.setParameter("name",positionName.toLowerCase());
            deletedCount = query.executeUpdate();
//            Position pos=getPositionByName(positionName);
//            session.delete(pos);
            transaction.commit();
            session.close();
            return deletedCount >=1 ? true: false;
        }catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            session.close();
            logger.error("failure to delete data",e);
        }return false;

    }

    @Override
    public Position getPositionEagerBy(Long id) {
        String hql = "FROM Position p LEFT JOIN FETCH p.player WHERE p.id=:Id";
        Session session = sessionFactory.openSession();
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
    public Position getPositionBy(Long id){
        String hql = "FROM Position pos where pos.id = :Id";
        Session session = sessionFactory.openSession();
        try {
            Query<Position> query = session.createQuery(hql);
            query.setParameter("Id", id);
            Position result = query.uniqueResult();
            session.close();
            return result;
        } catch (HibernateException e) {
            logger.error("failure to retrieve data record", e);
            return null;
        }
    }

    @Override
    public Set<Position> getPositionAndPlayers(String positionName) {
        if (positionName==null) return null;
        String hql = "FROM Position as position left join fetch position.player where lower(position.positionName)=:name";
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery(hql);
            query.setParameter("name",positionName.toLowerCase());
            List<Position> result= query.list();
            Set<Position> setresult= result.stream().collect(Collectors.toSet());
            session.close();
            return setresult;
        }catch (HibernateException e){
            logger.error("Can not get position and players",e);
            return null;
        }
    }

    @Override
    public Position update(Position position) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.update(position);
            transaction.commit();
            session.close();
            return position;
        } catch (Exception e) {
            if (transaction!= null) transaction.rollback();
            logger.error("failure to update the data",e);
            session.close();
        } return position;
    }

    @Override
    public Position getPositionByName(String positionName) {
        Position position = new Position();
        Transaction transaction = null;
        String hql = "FROM Position pos LEFT JOIN FETCH pos.player where pos.positionName = :name";
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query<Position> query = session.createQuery(hql);
            query.setParameter("name", positionName);
            position = query.uniqueResult();
            transaction.commit();
            session.close();
            return position;
        } catch (Exception e) {
            if (transaction != null)transaction.rollback();
            logger.error("failure to get position by name",e);
            session.close();
            return null;
        }
    }

    @Override
    public List<Position> getPositionList() {
        List<Position> positionList = new ArrayList<>();
        Transaction transaction = null;
        String hql ="From Position";
        Session session = sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            Query<Position> query = session.createQuery(hql);
            positionList=query.list();
            transaction.commit();
            session.close();
            return positionList;
        }catch (Exception e){
            if (transaction!=null)transaction.rollback();
            logger.error("failure to get position list",e);
            session.close();
            return null;
        }
    }
}
