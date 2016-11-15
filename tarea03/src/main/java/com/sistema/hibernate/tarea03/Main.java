package com.sistema.hibernate.tarea03;

import java.util.Date;

import com.sistema.hibernate.tarea03.dao.impl.HibernateFlightDAO;
import com.sistema.hibernate.tarea03.model.Flight;
import com.sistema.hibernate.tarea03.model.Passenger;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		Flight flight = new Flight("Apocalypse Flight", new Date(112, 11, 21));
		
		Passenger passenger1 = new Passenger("Muerte","666-666-666");
		Passenger passenger2 = new Passenger("Guerra","666-666-616");
		Passenger passenger3 = new Passenger("Hambre","666-616-616");
		Passenger passenger4 = new Passenger("Peste","666-616-666");
		
		flight.addPassenger(passenger1);
		flight.addPassenger(passenger2);
		flight.addPassenger(passenger3);
		flight.addPassenger(passenger4);
		
		HibernateFlightDAO hibernateFlightDAO = new HibernateFlightDAO();
		
		hibernateFlightDAO.insert(flight);
		
		System.out.println(hibernateFlightDAO.selectById(flight.getId()).toString());
	}
}
