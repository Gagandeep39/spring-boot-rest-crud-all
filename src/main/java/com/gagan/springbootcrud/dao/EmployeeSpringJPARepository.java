package com.gagan.springbootcrud.dao;

import com.gagan.springbootcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gagandeep
 * @date 14-04-2020
 * @time 08:07
 */
public interface EmployeeSpringJPARepository extends JpaRepository<Employee, Integer> {
}
