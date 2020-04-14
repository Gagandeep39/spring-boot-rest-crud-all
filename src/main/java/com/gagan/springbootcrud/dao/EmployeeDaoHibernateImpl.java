package com.gagan.springbootcrud.dao;

import com.gagan.springbootcrud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Gagandeep
 * @date 13-04-2020
 * @time 23:46
 *
 * Iplemtation using Hibernate
 */

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

    @Autowired
    private EntityManager manager;

    @Override
    public List<Employee> findAll() {
        Session currentSession = manager.unwrap(Session.class);
        Query<Employee> query = currentSession.createQuery("from employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Session currentSession = manager.unwrap(Session.class);
        return currentSession.get(Employee.class, id);
    }

    /**
     * Error: Executing an update/delete query; nested exception is javax.persistence.TransactionRequiredException: Executing an update/delete query",
     * Add @Transactional in service class to fix it
     * @param id
     */
    @Override
    public void deleteById(int id) {
        Session currentSession = manager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from employee where id=:empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        Session currentSession = manager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
        return employee;
    }
}
