package com.kaba.planner.service;

import com.kaba.planner.entity.City;
import com.kaba.planner.exception.PlannerError;
import com.kaba.planner.exception.PlannerException;
import com.kaba.planner.repository.CityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * City service implementation
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class CityServiceBean implements CityService {

    @Autowired
    private CityRepository repository;

    /**
     * No argument constructor
     */
    public CityServiceBean() {
    }

    @Override
    public Page<City> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    @Override
    public City findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public City create(City city) {
        return repository.save(city);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public City update(City city) throws PlannerException {
        if (null == city.getId()) {
            return null;
        }
        if (null == repository.findOne(city.getId())) {
            throw new PlannerException(PlannerError.E0001);
        }

        return repository.save(city);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) throws PlannerException {
        if (null == repository.findOne(id)) {
            throw new PlannerException(PlannerError.E0001);
        }
        repository.delete(id);
    }

    @Override
    public List<City> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public City findByNameAndCountry(String name, String country) {
        return repository.findByNameAndCountry(name, country);
    }

}
