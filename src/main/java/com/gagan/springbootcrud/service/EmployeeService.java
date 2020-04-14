package com.gagan.springbootcrud.service;

import com.gagan.springbootcrud.entity.Employee;

import java.util.List;

/**
 * @author Gagandeep
 * @date 14-04-2020
 * @time 00:12
 */
public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void deleteById(int id);

    public Employee addEmployee(Employee employee);
}
