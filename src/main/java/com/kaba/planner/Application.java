package com.kaba.planner;

import com.kaba.planner.entity.City;
import com.kaba.planner.entity.Workplace;
import com.kaba.planner.service.CityService;
import com.kaba.planner.service.CityServiceBean;
import com.kaba.planner.service.EmployeeService;
import com.kaba.planner.service.WorkplaceService;
import com.kaba.planner.service.WorkplaceServiceBean;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;

/**
 * Application class (main class)
 *
 * @author Kaba N'faly
 * @since 12/02/2016
 * @version 2.0
 */
@SpringBootApplication
@Import(AppConfiguration.class)
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

   
    @Bean
    public CommandLineRunner test(CityService cityService, WorkplaceService workplaceService) {
        return (arg) -> {

            if (null == cityService.findByNameAndCountry("Nice", "France")) {

                City city = cityService.create(new City("Nice", "France"));
                
                if (null == workplaceService.findByNameAndCity("Nice étoile", city)) {
                    workplaceService.create(new Workplace("Nice étoile", city));
                }
            }

            if (null == cityService.findByNameAndCountry("Montréal", "Canada")) {
                City city = cityService.create(new City("Montréal", "Canada"));
                
                if (null == workplaceService.findByNameAndCity("Walmart", city)) {
                    workplaceService.create(new Workplace("Walmart", city));
                }
            }

            if (null == cityService.findByNameAndCountry("Marseille", "France")) {
                City city = cityService.create(new City("Marseille", "France"));
                
                 if (null == workplaceService.findByNameAndCity("Carrefour", city)) {
                    workplaceService.create(new Workplace("Carrefour", city));
                }
            }

            List<City> cities = cityService.findAll(new PageRequest(0, 10)).getContent();

            cities.stream().forEach(System.out::println);
            
            List<Workplace> workplaces = workplaceService.findAll(new PageRequest(0, 10)).getContent();

            workplaces.stream().forEach(System.out::println);

        };
    }
}
