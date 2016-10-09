package com.samuel.entidade;

import java.util.List;

import javax.persistence.*;
 
@Entity
public class Dog {
 
    @Id
    @GeneratedValue
    private int id;
 
    private String name;
 
    @ManyToMany(mappedBy="dogs")
    private List<Cliente> persons;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cliente> getPersons() {
		return persons;
	}

	public void setPersons(List<Cliente> persons) {
		this.persons = persons;
	}
 
    // get and set
}