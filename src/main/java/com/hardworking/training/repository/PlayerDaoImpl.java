package com.hardworking.training.repository;

import com.hardworking.training.model.Player;
import com.hardworking.training.model.Position;
import com.hardworking.training.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
// PlayerDao player = new PlayerDaoImpl(); when spring start.
public class PlayerDaoImpl implements PlayerDao {
    private Logger logger = LoggerFactory.getLogger(PlayerDaoImpl.class);

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
        String hql = "FROM Player";
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
    public boolean delete(String name) {
        String hql = "DELETE Player as player where player.name = :name";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("name",name);
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
    public Player update(Player player) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(player);
            transaction.commit();
            session.close();
            return player;
        }
        catch (Exception e){
            if (transaction != null)transaction.rollback();
            logger.error("failure to update record",e);
            session.close();
            return null;
        }
    }

    @Override
    public Player getPlayerByName(String name) {
        Player player = new Player();
        Transaction transaction = null;
        String hql = "FROM Player p LEFT JOIN FETCH p.team where p.name = :name";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("name", name);
            player = query.uniqueResult();
            transaction.commit();
            session.close();
            return player;
        } catch (Exception e) {
            if (transaction != null)transaction.rollback();
            logger.error("failure to get player by name",e);
            session.close();
            return null;
        }
    }

    @Override
    public Player getPlayerById(Long id) {
        String hql = "FROM Player pla where pla.id = :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Player> query = session.createQuery(hql);
            query.setParameter("Id", id);
            Player result = query.uniqueResult();
            session.close();
            return result;
        } catch (HibernateException e) {
            logger.error("failure to retrieve data record", e);
            return null;
        }
    }
}
