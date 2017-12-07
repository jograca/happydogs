package com.lmig.gfc.happydogs.api;

import java.util.ArrayList;
import java.util.List;

import com.lmig.gfc.happydogs.model.Dog;
import com.lmig.gfc.happydogs.model.Person;

public class PersonView {

	private Person person;

	public PersonView(Person person) {
		this.person = person;
	}

	public Long getID() {
		return person.getId();
	}

	public String getFirstName() {
		return person.getFirstName();
	}

	public List<DogView> getPets() {
		ArrayList<DogView> views = new ArrayList<DogView>();
		for (Dog dog : person.getPets()) {
			views.add(new DogView(dog));
		}
		return views;
	}
}
