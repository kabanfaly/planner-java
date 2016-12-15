package com.kaba.planner.service;

import com.kaba.planner.entity.City;
import com.kaba.planner.entity.Workplace;
import com.kaba.planner.exception.PlannerError;
import com.kaba.planner.exception.PlannerException;
import com.kaba.planner.repository.WorkplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Workplace service implementation
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class WorkplaceServiceBean implements WorkplaceService {

    private WorkplaceRepository repository;

    @Autowired
    public WorkplaceServiceBean(WorkplaceRepository repository) {
        this.repository = repository;
    }

    public WorkplaceServiceBean() {
    }

    @Override
    public Page<Workplace> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    @Override
    public Workplace findById(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public Workplace findByNameAndCity(String name, City city) {
        return repository.findByNameAndCity(name, city);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Workplace create(Workplace workplace) {
        return repository.save(workplace);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Workplace update(Workplace workplace) throws PlannerException {
        if(null == workplace){
            return null;
        }
        
        if (null == repository.findOne(workplace.getId())) {
            throw new PlannerException(PlannerError.E0001);
        }
        return repository.save(workplace);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer id) throws PlannerException {
        if (null == repository.findOne(id)) {
            throw new PlannerException(PlannerError.E0001);
        }
        repository.delete(id);
    }
}
