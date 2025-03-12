package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employee;

import jakarta.transaction.Transactional;

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		sessionFactory.getCurrentSession().persist(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		sessionFactory.getCurrentSession().merge(employee);
	}

	@Override
	@Transactional
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
		if (employee != null) {
			session.delete(employee);
		}
	}

	@Override

	public Employee getById(int id) {
		return sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override

	public List<Employee> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Employee", Employee.class).list();
	}
}
