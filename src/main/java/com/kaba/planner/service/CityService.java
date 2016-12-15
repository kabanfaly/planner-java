package com.kaba.planner.service;

import com.kaba.planner.entity.City;
import com.kaba.planner.exception.PlannerException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * City service
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface CityService {

    /**
     * find all cities
     *
     * @return
     */
    Page<City> findAll(Pageable pgbl);

    /**
     * Find a city by its id
     *
     * @param id
     * @return City
     */
    City findById(Integer id);

    /**
     * Create a city
     *
     * @param city
     * @return City
     */
    City create(City city);

    /**
     * Update a city
     *
     * @param city
     * @return City
     */
    City update(City city) throws PlannerException;

    /**
     * Delete a city
     *
     * @param id
     */
    void delete(Integer id) throws PlannerException;
    
    /**
     * Find cities by name 
     * @param name
     * @return list of City
     */
    List<City> findByName(String name);
    
    /**
     * Find cities by name and country
     * @param name
     * @param country
     * @return City
     */
    City findByNameAndCountry(String name, String country);
}
