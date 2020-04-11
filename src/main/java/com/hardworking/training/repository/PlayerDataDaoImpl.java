package com.hardworking.training.repository;

import com.hardworking.training.model.PlayerData;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Repository
public class PlayerDataDaoImpl implements PlayerDataDao{
    private Logger logger= LoggerFactory.getLogger(PlayerData.class);
    @Override
    public PlayerData create(PlayerData playerData) {
        Transaction transaction=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try {
            transaction=session.beginTransaction();
            session.save(playerData);
            transaction.commit();
            session.close();
            return playerData;
        }catch (Exception e){
            if (transaction!=null) transaction.rollback();
            logger.error("Create failed",e);
            session.close();
        }return null;
    }

    @Override
    public boolean delete(Long id) {
        String hql= "DELETE PlayerData as p where p.id=:id";
        int deletedCount = 0;
        Transaction transaction=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try {
            transaction=session.beginTransaction();
            Query<PlayerData> query=session.createQuery(hql);
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
    public PlayerData update(PlayerData playerData) {
        Transaction transaction=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try {
            transaction=session.beginTransaction();
            session.update(playerData);
            transaction.commit();
            session.close();
            return playerData;
        }catch (Exception e){
            if (transaction!=null) transaction.rollback();
            logger.error("failed to update the data",e);
            session.close();
        }return null;
    }

    @Override
    public Set<PlayerData> getPlayerData() {
        String hql ="FROM PlayerData";
        Transaction transaction=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction=session.beginTransaction();
            Query query =session.createQuery(hql);
            List<PlayerData> result = query.list();
            Set<PlayerData> setResult= result.stream().collect(Collectors.toSet());
            transaction.commit();
            session.close();
            return setResult;
        }catch (HibernateException e){
            if (transaction!=null) transaction.rollback();
            logger.error("can't get player data",e);
            session.close();
        }return null;
    }
}
