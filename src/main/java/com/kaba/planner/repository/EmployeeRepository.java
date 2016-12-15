package com.kaba.planner.repository;

import com.kaba.planner.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Employee repository
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
