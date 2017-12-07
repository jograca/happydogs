package com.lmig.gfc.happydogs.api;

import java.util.List;

import com.lmig.gfc.happydogs.model.Dog;
import com.lmig.gfc.happydogs.model.Meal;

public class DogView {

	private Dog dog;

	public DogView(Dog dog) {
		this.dog = dog;
	}

	public Long getID() {
		return dog.getId();
	}

	public String getBreed() {
		return dog.getBreed();
	}

	public String getName() {
		return dog.getName();
	}

	public int getWeightInPounds() {
		return dog.getWeightInPounds();
	}

	public double getHeightInInches() {
		return dog.getHeightInInches();
	}

	public String getGender() {
		return dog.getGender();
	}

	public String getColor() {
		return dog.getColor();
	}

	public int getNumberOfLegs() {
		return dog.getNumberOfLegs();
	}

	public boolean isHappy() {
		return dog.isHappy();
	}

	public List<Meal> getMeals() {
		return dog.getMeals();
	}

}
