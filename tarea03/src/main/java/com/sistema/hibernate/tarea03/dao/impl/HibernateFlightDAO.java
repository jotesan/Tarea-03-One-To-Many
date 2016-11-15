package com.sistema.hibernate.tarea03.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sistema.hibernate.tarea03.HibernateSession;
import com.sistema.hibernate.tarea03.model.Flight;
import com.sistema.hibernate.tarea03.dao.FlightDAO;

public class HibernateFlightDAO implements FlightDAO{

	public Flight selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Flight flight = (Flight) session.get(Flight.class, id);
		session.close();
		return flight;
	}

	public List<Flight> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Flight> flights = session.createCriteria(Flight.class).list();
		session.close();
		return flights;
	}

	public void insert(Flight flight) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(flight);
		flight.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Flight flight) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(flight);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Flight flight) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(flight);
		session.getTransaction().commit();
		session.close();
	}
}
