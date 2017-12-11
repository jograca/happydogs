package com.lmig.gfc.happydogs.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lmig.gfc.happydogs.model.Dog;
import com.lmig.gfc.happydogs.services.DogRepository;

public class DogsApiControllerTests {

	private DogsApiController controller;
	private DogRepository dogRepo;

	@Before
	public void setup() {
		dogRepo = mock(DogRepository.class);
		controller = new DogsApiController(dogRepo);
	}

	@Test
	public void we_will_never_type_this_in_real_life() {
		assertThat(dogRepo).isNotNull();
	}

	@Test
	public void getAll_with_null_gender_returns_list_of_dogs() {
		// Arrange
		ArrayList<Dog> dogs = new ArrayList<Dog>();

		// when (the method call used in the code being tested
		// .thenReturn (a value that you created)
		when(dogRepo.findAll()).thenReturn(dogs);

		// Act - calls getAll() on Controller
		List<Dog> actual = controller.getAll(null);

		// Assert
		assertThat(dogs).isSameAs(actual);
		verify(dogRepo, times(1)).findAll();
	}

	@Test
	public void getAll_with_male_gender_returns_list_of_dogs() {
		// Arrange
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		when(dogRepo.findByGenderIgnoringCase("male")).thenReturn(dogs);

		// Act
		List<Dog> actual = controller.getAll("male");

		// Assert
		assertThat(dogs).isSameAs(actual);
		verify(dogRepo, times(1)).findByGenderIgnoringCase("male");
	}

	@Test
	public void create_saves_the_dog_and_returns_it() {
		// Arrange
		Dog dog = new Dog();
		when(dogRepo.save(dog)).thenReturn(dog);

		// Act
		Dog actual = controller.create(dog);

		// Assert
		assertThat(dog).isSameAs(actual);
		verify(dogRepo, times(1)).save(dog);
	}

	@Test
	public void getOne_with_valid_id_returns_single_dog() {
		// Arrange
		Dog dog = new Dog();
		when(dogRepo.findOne(1L)).thenReturn(dog);

		// Act
		Dog actual = controller.getOne(1L);

		// Assert
		assertThat(dog).isSameAs(actual);
		verify(dogRepo, times(1)).findOne(1L);
	}

	@Test
	public void getOne_with_an_invalid_id_returns_a_dog() {
		// Arrange
		// By default, a mock object returns null for any Object
		// Not setting up an Arrangement will return null for that Object
		when(dogRepo.findOne(1L)).thenReturn(null);

		// Act
		Dog actual = controller.getOne(1L);

		// Assert
		assertThat(actual).isNull();
		verify(dogRepo, times(1)).findOne(1L);
	}

	@Test
	public void update_with_a_valid_id_updates_a_single_dog() {

	}

}
