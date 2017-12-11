package com.lmig.gfc.happydogs.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.happydogs.model.Dog;
import com.lmig.gfc.happydogs.services.DogRepository;

@RestController
@RequestMapping("/api/dogs")
public class DogsApiController {

	private DogRepository dogRepo;

	public DogsApiController(DogRepository dogRepo) {
		this.dogRepo = dogRepo;
	}

	@GetMapping("")
	public List<Dog> getAll(@RequestParam(required = false) String gender) {
		if (gender != null) {
			return dogRepo.findByGenderIgnoringCase(gender);
		}
		return dogRepo.findAll();
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Dog create(@RequestBody Dog dog) {
		return dogRepo.save(dog);
	}

	@GetMapping("{id}")
	public Dog getOne(@PathVariable Long id) {
		return dogRepo.findOne(id);
	}

	@PutMapping("{id}")
	public Dog update(@RequestBody Dog dog, @PathVariable Long id) {
		dog.setId(id);
		return dogRepo.save(dog);
	}

	@DeleteMapping("{id}")
	public Dog delete(@PathVariable Long id) {
		Dog dog = dogRepo.findOne(id);
		dogRepo.delete(dog);
		return dog;
	}

}
