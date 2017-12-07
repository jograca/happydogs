package com.lmig.gfc.happydogs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "meal")
public class Meal {

	@Id
	@GeneratedValue(generator = "meal_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "meal_id_seq", sequenceName = "meal_id_seq")
	private Long id;

	// Many to one, Object that owns the thing
	// Does not require a FK Mapping
	@ManyToOne
	@JsonIgnore
	private Dog dog;

	@Column(nullable = false)
	private String food;

	public Meal() {

	}

	public Meal(Dog dog, String food) {
		this.dog = dog;
		this.food = food;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

}
