package com.lmig.gfc.happydogs.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.happydogs.model.Dog;
import com.lmig.gfc.happydogs.model.Person;
import com.lmig.gfc.happydogs.services.DogRepository;
import com.lmig.gfc.happydogs.services.PersonRepository;

@RestController
@RequestMapping("/api/dogs/{dogId}/owners")
public class OwnersApiController {

	private PersonRepository personRepo;
	private DogRepository dogRepo;

	public OwnersApiController(PersonRepository personRepo, DogRepository dogRepo) {
		this.personRepo = personRepo;
		this.dogRepo = dogRepo;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Dog create(@PathVariable Long dogId, @RequestBody Long personId) {

		Dog dog = dogRepo.findOne(dogId);
		Person person = personRepo.findOne(personId);

		if (!dog.getOwners().contains(person)) {
			// dog.addOwner(person);
			dog.getOwners().add(person);
			dogRepo.save(dog);
		}
		return dog;

	}
}
