package com.lmig.gfc.happydogs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(generator = "person_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "person_id_seq", sequenceName = "person_id_seq")
	private Long id;

	// Side that does not own the relationship gets the mapped by
	@ManyToMany(mappedBy = "owners")
	@JsonIgnore
	private List<Dog> pets;

	@Column(nullable = false)
	private String firstName;

	public Person() {

	}

	public Person(List<Dog> pets, String firstName) {
		this.pets = pets;
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Dog> getPets() {
		return pets;
	}

	public void setPets(List<Dog> pets) {
		this.pets = pets;
	}
}
