package com.cardata.CarData;

import com.cardata.CarData.domain.Car;
import com.cardata.CarData.domain.Owner;
import com.cardata.CarData.domain.User;
import com.cardata.CarData.repository.CarRepository;
import com.cardata.CarData.repository.OwnerRepository;
import com.cardata.CarData.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarDataApplication extends SpringBootServletInitializer{

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected SpringApplicationBuilder configure
			(SpringApplicationBuilder application) {
		return application.sources(CarDataApplication.class);
	}

	// After adding this comment the application is restarted
	public static void main(String[] args) throws Exception {

		SpringApplication.run(CarDataApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("John", "Johnson");
			Owner owner2 = new Owner("Mary", "Robinson");
			Owner owner3 = new Owner("Steven", "John");

			ownerRepository.save(owner1);
			ownerRepository.save(owner2);
			ownerRepository.save(owner3);

			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));
			carRepository.save(new Car("Jeep", "Grey", "Landcruiser", "GHN-123", 2020, 85000, owner3));

			// username: user password: user
			userRepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			// username: admin password: admin
			userRepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));
		};
	}
}