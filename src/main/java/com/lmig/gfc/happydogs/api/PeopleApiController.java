package com.lmig.gfc.happydogs.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.happydogs.model.Person;
import com.lmig.gfc.happydogs.services.PersonRepository;

@RestController
@RequestMapping("/api/people")
public class PeopleApiController {

	private PersonRepository personRepo;

	public PeopleApiController(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}

	@GetMapping("")
	public List<Person> getAll() {
		return personRepo.findAll();
	}
}
