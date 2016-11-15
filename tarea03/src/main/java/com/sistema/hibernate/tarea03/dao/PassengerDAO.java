package com.sistema.hibernate.tarea03.dao;

import java.util.List;

import com.sistema.hibernate.tarea03.model.Passenger;

public interface PassengerDAO {

	public Passenger selectById(Long id);

	public List<Passenger> selectAll();

	public void insert(Passenger Passenger);

	public void update(Passenger Passenger);

	public void delete(Passenger Passenger);
}
