package com.kaba.planner.service;

import com.kaba.planner.entity.City;
import com.kaba.planner.repository.CityRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
    private CityRepository cityRepository;

    @Autowired
    private CityService service;

    private City city;

    @Before
    public void setUp() {
        cityRepository.deleteAll();
        city = new City("Nice", "France");
        city = cityRepository.save(city);
    }

    /**
     * Test of findAll method, of class CityServiceBean.
     */
    @Test
    public void testFindAll() {

        Page<City> cities = service.findAll(new PageRequest(0, 10));
        assertEquals(1, cities.getContent().size());
    }

    /**
     * Test of findById method, of class CityServiceBean.
     */
    @Test
    public void testFindById() {
        assertEquals(city, service.findById(city.getId()));
    }

    /**
     * Test of create method, of class CityServiceBean.
     */
    @Test
    public void testCreate() {
        
        City newCity = new City("Marseille", "France");
        City savedCity = service.create(newCity);
        
        assertEquals(savedCity.getName(), newCity.getName());
        assertEquals(savedCity.getCountry(), newCity.getCountry());

    }

    /**
     * Test of update method, of class CityServiceBean.
     */
    @Test
    public void testUpdate() throws Exception {
       city.setName("Monaco");
       City updatedCity = service.update(city);
       
       assertEquals(updatedCity.getName(), city.getName());
    }

    /**
     * Test of delete method, of class CityServiceBean.
     */
    @Test
    public void testDelete() throws Exception {
        
        assertEquals(1, cityRepository.count());
        
        service.delete(city.getId());
        
        assertEquals(0, cityRepository.count());
    }

    /**
     * Test of findByName method, of class CityServiceBean.
     */
    @Test
    public void testFindByName() {
        assertEquals(0, service.findByName("NOT_FOUND").size());
        assertEquals(1, service.findByName(city.getName()).size());
    }
    
    /**
     * Test of findByNameAndCountry method, of class CityServiceBean.
     */
    @Test
    public void testFindByNameAndCountry() {
        assertNull(service.findByNameAndCountry("", ""));
        City found = service.findByNameAndCountry("Nice", "France");
        assertEquals(found.getName(), city.getName());
        assertEquals(found.getCountry(), city.getCountry());
    }

}
