package com.example.donation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DonorDAO {

    public void save(Donor donor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(donor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Donor get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Donor.class, id);
        }
    }

    public List<Donor> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Donor", Donor.class).list();
        }
    }
}
