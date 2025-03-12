package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDao {
	void save(Employee employee);

	void update(Employee employee);

	void delete(int id);

	Employee getById(int id);

	List<Employee> getAll();
}
