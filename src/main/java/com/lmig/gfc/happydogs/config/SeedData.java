package com.lmig.gfc.happydogs.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.happydogs.model.Dog;
import com.lmig.gfc.happydogs.services.DogRepository;

@Configuration
public class SeedData {

	public SeedData(DogRepository dogRepo) {
		dogRepo.save(new Dog(14, "Lab", "Digby", 8.4, "Male", "Black", 4, true, new Date(2015, 8, 14)));
		dogRepo.save(new Dog(2, "Lab", "Wicket", 8.4, "Female", "Black", 4, true, new Date(2010, 10, 12)));
		dogRepo.save(new Dog(16, "Lab", "Sid", 8.4, "Male", "Black", 4, true, new Date(2008, 10, 12)));
		dogRepo.save(new Dog(8, "Lab", "Milo", 8.4, "Male", "Yellow", 4, true, new Date(2011, 4, 25)));
	}

}
