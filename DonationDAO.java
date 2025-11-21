package com.example.donation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DonationDAO {

    public void save(Donation donation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(donation);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Donation get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Donation.class, id);
        }
    }

    public List<Donation> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Donation", Donation.class).list();
        }
    }
}
