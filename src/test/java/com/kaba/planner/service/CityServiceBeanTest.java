package com.kaba.planner.service;

import com.kaba.planner.entity.City;
import com.kaba.planner.repository.CityRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author kaba
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CityServiceBeanTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CityRepository repository;
    
    @Autowired
    private CityServiceBean service;
    
    private City city;
    
    @Before
    public void setUp() {
        city = new City("Nice", "France");
        entityManager.persist(city);
    }
    

    /**
     * Test of findAll method, of class CityServiceBean.
     */
    @Test
    public void testFindAll() {
        {
            Page<City> cities = service.findAll(new PageRequest(0, 10));
            assertEquals(1, cities.getContent().isEmpty());
        }
    }

    /**
     * Test of findById method, of class CityServiceBean.
     */
//    @Test
    public void testFindById() {
    }

    /**
     * Test of create method, of class CityServiceBean.
     */
//    @Test
    public void testCreate() {
    }

    /**
     * Test of update method, of class CityServiceBean.
     */
//    @Test
    public void testUpdate() throws Exception {
    }

    /**
     * Test of delete method, of class CityServiceBean.
     */
//    @Test
    public void testDelete() throws Exception {
    }

    /**
     * Test of findByName method, of class CityServiceBean.
     */
//    @Test
    public void testFindByName() {
    }

}
