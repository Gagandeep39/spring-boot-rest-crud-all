package com.gagan.springbootcrud.dao;

import com.gagan.springbootcrud.entity.Employee;

import java.util.List;

/**
 * @author Gagandeep
 * @date 13-04-2020
 * @time 23:45
 */
public interface EmployeeDao {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void deleteById(int id);

    public Employee addEmployee(Employee employee);
}
