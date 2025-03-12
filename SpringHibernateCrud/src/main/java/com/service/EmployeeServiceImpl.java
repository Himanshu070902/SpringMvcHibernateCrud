package com.service;

import java.util.List;

import com.dao.EmployeeDao;
import com.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
	}

	@Override
	public Employee getById(int id) {
		return employeeDao.getById(id);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
}
