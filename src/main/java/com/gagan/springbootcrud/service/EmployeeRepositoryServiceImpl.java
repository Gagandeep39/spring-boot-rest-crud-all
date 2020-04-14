package com.gagan.springbootcrud.service;

import com.gagan.springbootcrud.dao.EmployeeSpringJPARepository;
import com.gagan.springbootcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Gagandeep
 * @date 14-04-2020
 * @time 08:09
 */

/**
 * Ensure there is @service tag
 */
@Service
public class EmployeeRepositoryServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeSpringJPARepository repository;

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }
}
