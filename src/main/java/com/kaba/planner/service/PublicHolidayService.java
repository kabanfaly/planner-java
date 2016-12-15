package com.kaba.planner.service;

import com.kaba.planner.entity.PublicHoliday;
import org.springframework.data.domain.Page;

/**
 * PublicHoliday service 
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface PublicHolidayService {
    
    /**
     * find all public holidays
     * @return 
     */
    Page<PublicHoliday> findAll();
    
    /**
     * Create a public holiday
     * @param publicholiday
     * @return 
     */
    PublicHoliday create(PublicHoliday publicholiday);
    
    /**
     * Update a public holiday
     * @param publicholiday
     * @return 
     */
    PublicHoliday update(PublicHoliday publicholiday);
    
    /**
     * Delete a public holiday
     * @param id 
     */
    void delete(Integer id);
}
