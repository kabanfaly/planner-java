package com.kaba.planner.service;

import com.kaba.planner.entity.Employee;
import org.springframework.data.domain.Page;

/**
 * Employee service 
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface EmployeeService {
    
    /**
     * find all employees
     * @return 
     */
    Page<Employee> findAll();
    
    /**
     * Create a employee
     * @param employee
     * @return 
     */
    Employee create(Employee employee);
    
    /**
     * Update a employee
     * @param employee
     * @return 
     */
    Employee update(Employee employee);
    
    /**
     * Delete a employee
     * @param id 
     */
    void delete(Integer id);
}
