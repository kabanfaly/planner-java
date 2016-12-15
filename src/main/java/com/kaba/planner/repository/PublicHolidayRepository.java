package com.kaba.planner.repository;

import com.kaba.planner.entity.PublicHoliday;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PublicHoliday repository
 *
 * @author Kaba N'faly
 * @since 12/03/2016
 * @version 2.0
 */
public interface PublicHolidayRepository extends JpaRepository<PublicHoliday, Integer> {

}
