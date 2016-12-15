package com.kaba.planner.repository;

import com.kaba.planner.entity.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * City repository
 *
 * @author Kaba N'faly
 * @since 12/02/2016
 * @version 2.0
 */
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByName(String name);
    City findByNameAndCountry(String name, String country);
}
