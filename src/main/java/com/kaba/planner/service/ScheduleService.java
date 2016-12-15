package com.kaba.planner.service;

import com.kaba.planner.entity.Schedule;
import org.springframework.data.domain.Page;

/**
 * Schedule service 
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface ScheduleService {
    
    /**
     * find all schedules
     * @return 
     */
    Page<Schedule> findAll();
    
    /**
     * Create a schedule
     * @param schedule
     * @return 
     */
    Schedule create(Schedule schedule);
    
    /**
     * Update a schedule
     * @param schedule
     * @return 
     */
    Schedule update(Schedule schedule);
    
    /**
     * Delete a schedule
     * @param id 
     */
    void delete(Integer id);
}
