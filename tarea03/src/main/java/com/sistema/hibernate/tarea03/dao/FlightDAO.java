package com.sistema.hibernate.tarea03.dao;

import java.util.List;

import com.sistema.hibernate.tarea03.model.Flight;

public interface FlightDAO {
	
	public Flight selectById(Long id);

	public List<Flight> selectAll();

	public void insert(Flight flight);

	public void update(Flight flight);

	public void delete(Flight flight);

}
