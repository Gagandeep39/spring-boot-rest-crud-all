package com.gagan.springbootcrud.controller;

import com.gagan.springbootcrud.dao.EmployeeDao;
import com.gagan.springbootcrud.entity.Employee;
import com.gagan.springbootcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gagandeep
 * @date 13-04-2020
 * @time 23:53
 */

@RestController
@RequestMapping("/")
public class EmployeeRestController {

    @Qualifier("employeeRepositoryServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    /**
     * Return all employee
     */
    @GetMapping("/employees")
    public List<Employee> fetchAllEmployees(){
        return employeeService.findAll();
    }

    /**
     *
     * @param id To search for employee
     * @return Employee whose id was passed as argument
     */
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if (employee == null)
            throw  new RuntimeException("Employee Not Found");
        return employee;
    }

    /**
     * To fix Table 'DBNAME.hibernate_sequence' doesn't exist
     * Change Entity id generation strategy from auto to identity
     * OR
     * add this in properties file
     * spring.jpa.hibernate.use-new-id-generator-mappings= false
     * @param employee To be saved in database
     * @return Employee with new;y generated ID
     */
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    /**
     * To update an employee
     * @param employee Updated employee data
     * @return Returning same employee after updation
     */
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public int deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        System.out.println(employee);
        if (employee == null)
            throw  new RuntimeException("Employee Not Found");
        employeeService.deleteById(id);
        return id;
    }
}
