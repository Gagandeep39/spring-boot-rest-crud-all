package com.gagan.springbootcrud.dao;

import com.gagan.springbootcrud.entity.Employee;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Gagandeep
 * @date 14-04-2020
 * @time 07:57
 */
public class EmployeeDaoJpaImpl implements EmployeeDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return entityManager.merge(employee);
    }
}
