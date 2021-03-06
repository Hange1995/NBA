package com.hardworking.training.repository;



import com.hardworking.training.model.Player;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
// PlayerDao player = new PlayerDaoImpl(); when spring start.
public class PlayerDaoImpl implements PlayerDao {
    private Logger logger = LoggerFactory.getLogger(PlayerDaoImpl.class);
    private final Long currentSeason = 2020L;
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Player save(Player player) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(player);
            transaction.commit();
            session.close();
            return player;
        } catch (Throwable throwable) {
            if (transaction != null) transaction.rollback();
            logger.error("failure to insert record", throwable);
            session.close();
            return null;
        }
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        String hql = "FROM Player";
        Session session = sessionFactory.openSession();
        try {
            Query<Player> query = session.createQuery(hql);
            players = query.list();
            session.close();
            return players;
        } catch (HibernateException e) {
            logger.error("failure to retrieve data record", e);
            return players;
        }
    }

    @Override
    public boolean delete(String name) {
        String hql = "DELETE Player as player where player.name = :name";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("name", name);
            deletedCount = query.executeUpdate();
            transaction.commit();
            session.close();
            return deletedCount >= 1 ? true : false;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            session.close();
            logger.error("unable to delete record", e);
        }
        return false;
    }

    @Override
    public Player update(Player player) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.update(player);
            transaction.commit();
            session.close();
            return player;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("failure to update record", e);
            session.close();
            return null;
        }
    }

    @Override
    public Player getPlayerByName(String name) {
        Player player = new Player();
        Transaction transaction = null;
        String hql = "FROM Player p left join fetch p.team left join fetch p.position where p.name=:name";
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("name", name);
            player = query.uniqueResult();
            transaction.commit();
            session.close();
            return player;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            logger.error("failure to get player by name", e);
            session.close();
            return null;
        }
    }

    @Override
    public Player getPlayerById(Long id) {
        String hql = "FROM Player pla where pla.id = :Id";
        Session session = sessionFactory.openSession();
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

    @Override
    public Player getPlayerData(String name) {
        String hql = "FROM Player as p left join fetch p.seasonData where p.name=:name";
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query<Player> query = session.createQuery(hql);
            query.setParameter("name", name);
            Player result = query.uniqueResult();
            transaction.commit();
            session.close();
            return result;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error("can't find the player and the data by player's name", e);
            session.close();
        }
        return null;
    }

    @Override
    public Set<Player> getAllPlayerAndCurrentSeasonData() {
        List<Player> players = new ArrayList<>();
        String hql = "FROM Player as p left join fetch p.seasonData as sd where sd.season=:season";
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("season", currentSeason);
            players = query.getResultList();
            Set<Player> result = players.stream().collect(Collectors.toSet());
            transaction.commit();
            session.close();
            return result;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error("can't get all player and data", e);
            session.close();
            return null;
        }
    }

    @Override
    public Set<Player> getAllPlayerAndData() {
        List<Player> players = new ArrayList<>();
        String hql = "FROM Player as p left join fetch p.seasonData";
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            players = query.getResultList();
            Set<Player> result = players.stream().collect(Collectors.toSet());
            transaction.commit();
            session.close();
            return result;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error("can't get all player and data", e);
            session.close();
            return null;
        }
    }

    @Override
    public Set<Player> getAllPlayerWhoHasXpointsScoreYSeason(Double score, Long season) {
        List<Player> players = new ArrayList<>();
        String hql = "FROM Player as p left join fetch p.seasonData as sd where sd.season=:season" +
                " and sd.score>:score";
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("score", score);
            query.setParameter("season", season);
            players = query.getResultList();
            Set<Player> result = players.stream().collect(Collectors.toSet());
            transaction.commit();
            session.close();
            return result;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error("can't get all player and data", e);
            session.close();
            return null;
        }
    }

    @Override
    public List<Player> getAllPlayerAndCurrentSeasonDataInOrder() {
        List<Player> players = new ArrayList<>();
        String hql = "FROM Player as p left join fetch p.seasonData as sd where sd.season=:season order by sd.score desc";
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("season", currentSeason);
            players = query.getResultList();
            transaction.commit();
            session.close();
            return players;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error("can't get all player and data", e);
            session.close();
            return null;
        }
    }
}
