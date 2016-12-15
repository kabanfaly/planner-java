package com.kaba.planner.service;

import com.kaba.planner.entity.City;
import com.kaba.planner.entity.Workplace;
import com.kaba.planner.exception.PlannerException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Workplace service
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface WorkplaceService {

    /**
     * find all workplaces
     *
     * @return Page of Workplace
     */
    Page<Workplace> findAll(Pageable pgbl);

    /**
     * Find a workplace by its id
     *
     * @param id
     * @return Workplace
     */
    Workplace findById(Integer id);

    /**
     * Find a workplace by name and city id
     *
     * @param name
     * @param city
     * @return Workplace
     */
    Workplace findByNameAndCity(String name, City city);

    /**
     * Create a workplace
     *
     * @param workplace
     * @return Workplace
     */
    Workplace create(Workplace workplace);

    /**
     * Update a workplace
     *
     * @param workplace
     * @return Workplace
     */
    Workplace update(Workplace workplace) throws PlannerException;

    /**
     * Delete a workplace
     *
     * @param id
     */
    void delete(Integer id) throws PlannerException;
}
