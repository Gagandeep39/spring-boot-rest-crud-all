package com.gagan.springbootcrud.service;

import com.gagan.springbootcrud.dao.EmployeeDao;
import com.gagan.springbootcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Gagandeep
 * @date 14-04-2020
 * @time 00:12
 */

@Repository
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * Change the qualifier as per convenience
     * Like whiich ever method is to be used
     */
    @Qualifier("employeeDaoHibernateImpl")
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }
}
