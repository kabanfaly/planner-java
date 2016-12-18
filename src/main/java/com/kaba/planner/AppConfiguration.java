package com.kaba.planner;

import com.kaba.planner.service.CityService;
import com.kaba.planner.service.CityServiceBean;
import com.kaba.planner.service.WorkplaceService;
import com.kaba.planner.service.WorkplaceServiceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class
 *
 * @author Kaba N'faly
 * @since 12/18/2016
 * @version 2.0
 */
@Configuration
public class AppConfiguration {

    @Bean
    public CityService cityServiceBean() {
        return new CityServiceBean();
    }

    @Bean
    public WorkplaceService workplaceServiceBean() {
        return new WorkplaceServiceBean();
    }
}
