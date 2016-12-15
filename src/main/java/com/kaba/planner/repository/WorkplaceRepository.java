package com.kaba.planner.repository;

import com.kaba.planner.entity.City;
import com.kaba.planner.entity.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Workplace repository
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
    Workplace findByNameAndCity(String name, City city);
}
