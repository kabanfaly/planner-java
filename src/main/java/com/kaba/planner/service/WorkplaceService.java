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
     * @param pgbl pageable to paginate data
     * @return Page of Workplace
     */
    Page<Workplace> findAll(Pageable pgbl);

    /**
     * Find a workplace by its id
     *
     * @param id Workplace id
     * @return Workplace
     */
    Workplace findById(Integer id);

    /**
     * Find a workplace by name and city id
     *
     * @param name name of the workplace
     * @param city city of the workplace
     * @return Workplace
     */
    Workplace findByNameAndCity(String name, City city);

    /**
     * Create a workplace
     *
     * @param workplace workplace to create
     * @return Workplace
     */
    Workplace create(Workplace workplace);

    /**
     * Update a workplace
     *
     * @param workplace workplace to update
     * @return Workplace
     * @throws com.kaba.planner.exception.PlannerException
     */
    Workplace update(Workplace workplace) throws PlannerException;

    /**
     * Delete a workplace
     *
     * @param id id of the workplace to delete
     * @throws com.kaba.planner.exception.PlannerException
     */
    void delete(Integer id) throws PlannerException;
}
