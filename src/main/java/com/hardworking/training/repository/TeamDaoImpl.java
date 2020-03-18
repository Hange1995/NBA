package com.hardworking.training.repository;

import com.hardworking.training.model.Player;
import com.hardworking.training.model.Team;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TeamDaoImpl implements TeamDao {
    private Logger logger = LoggerFactory.getLogger(TeamDao.class);

    @Override
    public Team save(Team team) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(team);
            transaction.commit();
            session.close();
            return team;
        }
        catch (Throwable throwable){
            if (transaction != null)transaction.rollback();
            logger.error("failure to insert record",throwable);
            session.close();
            return null;
        }
    }

    @Override
    public boolean delete(Team team) {
        String hql = "DELETE Team as team where team.name = :name";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("name",team.getName());
            deletedCount = query.executeUpdate();
            transaction.commit();
            session.close();
            return deletedCount >=1 ? true: false;
        }catch (HibernateException e){
            if (transaction != null ) transaction.rollback();
            session.close();
            logger.error("unable to delete record",e);
        }return false;
    }

    @Override
    public Team getTeamEagerBy(Long id) {
        String hql = "FROM Team t LEFT JOIN FETCH t.player where t.id = :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Team> query = session.createQuery(hql);
            query.setParameter("Id", id);
            Team result = query.uniqueResult();
            session.close();
            return result;
        } catch (HibernateException e) {
            logger.error("failure to retrieve data record", e);
            return null;
        }
    }

    @Override
    public Team getTeamBy(Long id) {
        String hql = "FROM Team t where t.id = :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Team> query = session.createQuery(hql);
            query.setParameter("Id", id);
            Team result = query.uniqueResult();
            session.close();
            return result;
        } catch (HibernateException e) {
            logger.error("failure to retrieve data record", e);
            return null;
        }
    }
}