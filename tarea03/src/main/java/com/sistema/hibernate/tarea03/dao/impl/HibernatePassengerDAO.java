package com.sistema.hibernate.tarea03.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sistema.hibernate.tarea03.HibernateSession;
import com.sistema.hibernate.tarea03.dao.PassengerDAO;
import com.sistema.hibernate.tarea03.model.Passenger;

public class HibernatePassengerDAO implements PassengerDAO{

	public Passenger selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Passenger passenger = (Passenger) session.get(Passenger.class, id);
		session.close();
		return passenger;
	}

	public List<Passenger> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Passenger> passengers = session.createCriteria(Passenger.class).list();
		session.close();
		return passengers;
	}

	public void insert(Passenger passenger) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(passenger);
		passenger.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Passenger passenger) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(passenger);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Passenger passenger) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(passenger);
		session.getTransaction().commit();
		session.close();
	}
}
