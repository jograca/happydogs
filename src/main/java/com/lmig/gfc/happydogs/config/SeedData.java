package com.lmig.gfc.happydogs.config;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.happydogs.model.Dog;
import com.lmig.gfc.happydogs.model.Meal;
import com.lmig.gfc.happydogs.model.Person;
import com.lmig.gfc.happydogs.services.DogRepository;
import com.lmig.gfc.happydogs.services.MealRepository;
import com.lmig.gfc.happydogs.services.PersonRepository;

@Configuration
public class SeedData {

	public SeedData(DogRepository dogRepo, MealRepository mealRepo, PersonRepository personRepo) {

		Dog digby = dogRepo.save(new Dog(15, "Lab", "Digby", 8.4, "Male", "Black", 4, true, new Date(2015, 8, 14)));
		Dog wicket = dogRepo.save(new Dog(2, "Lab", "Wicket", 8.4, "Female", "Black", 4, true, new Date(2010, 10, 12)));
		Dog sid = dogRepo.save(new Dog(16, "Lab", "Sid", 8.4, "Male", "Black", 4, true, new Date(2008, 10, 12)));
		Dog milo = dogRepo.save(new Dog(8, "Lab", "Milo", 8.4, "Male", "Yellow", 4, true, new Date(2011, 4, 25)));

		mealRepo.save(new Meal(wicket, "Alpo"));
		mealRepo.save(new Meal(digby, "Steak"));
		mealRepo.save(new Meal(sid, "Alpo"));
		mealRepo.save(new Meal(milo, "Alpo"));

		Person owner = new Person();
		owner.setFirstName("Barry");
		personRepo.save(owner);

		ArrayList<Person> owners = new ArrayList<Person>();
		owners.add(owner);
		wicket.setOwners(owners);
		dogRepo.save(wicket);
	}

}
