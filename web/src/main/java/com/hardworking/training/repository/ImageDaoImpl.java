package com.hardworking.training.repository;

import com.hardworking.training.model.Image;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDaoImpl implements ImageDao {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Image save(Image image) {
        Transaction transaction=null;
        Session session=sessionFactory.openSession();
        try{
            transaction=session.beginTransaction();
            session.save(image);
            transaction.commit();
            session.close();
            return image;
        }catch (HibernateException e){
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
            session.close();
            return null;
        }
    }

}
