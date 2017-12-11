package com.lmig.gfc.happydogs.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

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
}
