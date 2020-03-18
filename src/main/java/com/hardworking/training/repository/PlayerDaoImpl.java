package com.hardworking.training.repository;

import com.hardworking.training.jdbc.PlayerJDBCDao;
import com.hardworking.training.model.Player;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PlayerDaoImpl implements PlayerDao {
    private Logger logger = LoggerFactory.getLogger(PlayerJDBCDao.class);

    @Override
    public Player save(Player player) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(player);
            transaction.commit();
            session.close();
            return player;
        }
        catch (Throwable throwable){
            if (transaction != null)transaction.rollback();
            logger.error("failure to insert record",throwable);
            session.close();
            return null;
        }
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        String hql = "FROM player";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Player> query = session.createQuery(hql);
            players = query.list();
            session.close();
            return players;
        }catch (HibernateException e){
            logger.error("failure to retrieve data record",e);
            return players;
        }
    }

    @Override
    public boolean delete(Player player) {
        String hql = "DELETE player as player where player.id = :id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("id",player.getId());
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
}
