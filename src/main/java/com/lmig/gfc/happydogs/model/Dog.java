package com.lmig.gfc.happydogs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "dog")
public class Dog {

	@Id
	@GeneratedValue(generator = "dog_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "dog_id_seq", sequenceName = "dog_id_seq")
	private Long id;

	// Mapped by - which variable in the other class
	// should I look at for this mapping?
	@OneToMany(mappedBy = "dog")
	private List<Meal> meals;

	// Side that does not own the relationship gets the mapped by
	@ManyToMany
	private List<Person> owners;

	@Column(length = 15, nullable = false)
	private String breed;

	@Column(length = 15)
	private String name;

	private int weightInPounds;
	private double heightInInches;
	private String gender;
	private String color;
	private int numberOfLegs;
	private boolean isHappy;
	private Date birthdate;

	public Dog() {

	}

	public Dog(int weightInPounds, String breed, String name, double heightInInches, String gender, String color,
			int numberOfLegs, boolean isHappy, Date birthdate) {
		this.weightInPounds = weightInPounds;
		this.breed = breed;
		this.name = name;
		this.heightInInches = heightInInches;
		this.gender = gender;
		this.color = color;
		this.numberOfLegs = numberOfLegs;
		this.isHappy = isHappy;
		this.birthdate = birthdate;
	}

	public int getWeightInPounds() {
		return weightInPounds;
	}

	public void setWeightInPounds(int weightInPounds) {
		this.weightInPounds = weightInPounds;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeightInInches() {
		return heightInInches;
	}

	public void setHeightInInches(double heightInInches) {
		this.heightInInches = heightInInches;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}

	public boolean isHappy() {
		return isHappy;
	}

	public void setHappy(boolean isHappy) {
		this.isHappy = isHappy;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public List<Person> getOwners() {
		return owners;
	}

	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}

}