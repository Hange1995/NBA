package com.hardworking.training.repository;

import com.hardworking.training.model.SeasonData;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Repository
public class SeasonDataDaoImpl implements SeasonDataDao {
    private Logger logger= LoggerFactory.getLogger(SeasonData.class);
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public SeasonData create(SeasonData seasonData) {
        Transaction transaction=null;
        Session session= sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            session.save(seasonData);
            transaction.commit();
            session.close();
            return seasonData;
        }catch (Exception e){
            if (transaction!=null) transaction.rollback();
            logger.error("Create failed",e);
            session.close();
        }return null;
    }

    @Override
    public boolean delete(Long id) {
        String hql= "DELETE SeasonData as p where p.id=:id";
        int deletedCount = 0;
        Transaction transaction=null;
        Session session= sessionFactory.openSession();
        try {
            transaction=session.beginTransaction();
            Query<SeasonData> query=session.createQuery(hql);
            query.setParameter("id",id);
//            query.setParameter("season",season);
            deletedCount=query.executeUpdate();
            transaction.commit();
            session.close();
            return deletedCount >=1 ? true: false;
        }catch (HibernateException e){
            if (transaction!=null) transaction.rollback();
            logger.error("you can't delete this record",e);
            session.close();
        }return false;
    }

    @Override
    public SeasonData update(SeasonData seasonData) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.update(seasonData);
            transaction.commit();
            session.close();
            return seasonData;
        }
        catch (Exception e){
            if (transaction != null)transaction.rollback();
            logger.error("failure to update record",e);
            session.close();
            return null;
        }
    }

    @Override
    public Set<SeasonData> getPlayerData() {
        String hql ="FROM SeasonData";
        Transaction transaction=null;
        Session session = sessionFactory.openSession();
        try{
            transaction=session.beginTransaction();
            Query query =session.createQuery(hql);
            List<SeasonData> result = query.list();
            Set<SeasonData> setResult= result.stream().collect(Collectors.toSet());
            transaction.commit();
            session.close();
            return setResult;
        }catch (HibernateException e){
            if (transaction!=null) transaction.rollback();
            logger.error("can't get player data",e);
            session.close();
        }return null;
    }

    @Override
    public SeasonData getXSeasonPlayerDataForPlayer(Long playerId, Long season) {
        String hql ="FROM SeasonData as pd where (pd.player.id=:id) and (pd.season=:season)";
        Transaction transaction=null;
        Session session = sessionFactory.openSession();
        try{
            transaction=session.beginTransaction();
            Query<SeasonData> query = session.createQuery(hql);
            query.setParameter("id",playerId);
            query.setParameter("season",season);
            SeasonData result= query.uniqueResult();
            transaction.commit();
            session.close();
            return result;
        }catch (HibernateException e){
            if (transaction!=null) transaction.rollback();
            logger.error("can't get player data",e);
            session.close();
        }return null;
    }
}
