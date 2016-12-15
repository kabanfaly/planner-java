package com.kaba.planner.repository;

import com.kaba.planner.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Schedule repository
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
