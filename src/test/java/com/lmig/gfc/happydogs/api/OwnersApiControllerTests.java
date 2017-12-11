package com.lmig.gfc.happydogs.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lmig.gfc.happydogs.model.Dog;
import com.lmig.gfc.happydogs.model.Person;
import com.lmig.gfc.happydogs.services.DogRepository;
import com.lmig.gfc.happydogs.services.PersonRepository;

public class OwnersApiControllerTests {

	private OwnersApiController controller;

	@Mock
	private PersonRepository personRepo;

	@Mock
	private DogRepository dogRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		controller = new OwnersApiController(personRepo, dogRepo);
	}

	@Test
	public void creates_saves_dog_when_peson_is_not_an_owner() {
		// Arrange
		Dog dog = new Dog();
		// Set Owners to empty array list
		dog.setOwners(new ArrayList<Person>());
		Person person = new Person();
		when(dogRepo.findOne(1L)).thenReturn(dog);
		when(personRepo.findOne(1L)).thenReturn(person);

		// Act
		Dog actual = controller.create(1L, 1L);

		// Assert
		assertThat(actual).isSameAs(dog);
		verify(dogRepo).save(dog);
		assertThat(dog.getOwners()).contains(person);
		verify(dogRepo).findOne(1L);
		verify(personRepo).findOne(1L);

	}

	@Test
	public void create_does_not_save_a_dog_if_the_person_already_owns_it() {
		// Arrange
		Person person = new Person();
		ArrayList<Person> owners = new ArrayList<Person>();
		owners.add(person);
		Dog dog = new Dog();
		dog.setOwners(owners);

		when(dogRepo.findOne(2L)).thenReturn(dog);
		when(personRepo.findOne(2L)).thenReturn(person);

		// Act
		Dog actual = controller.create(2L, 2L);

		// Assert
		verify(dogRepo).findOne(2L);
		verify(personRepo).findOne(2L);
		assertThat(actual).isSameAs(dog);
		assertThat(dog.getOwners()).contains(person);
		verify(dogRepo, never()).save(dog);
		assertThat(dog.getOwners()).hasSize(1);
	}

}
