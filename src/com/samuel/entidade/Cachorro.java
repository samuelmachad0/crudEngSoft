package com.samuel.entidade;

import java.util.List;

import javax.persistence.*;
 
@Entity
public class Cachorro {
 
    @Id
    @GeneratedValue
    private int id;
 
    private String name;
 
    @ManyToMany(mappedBy="dogs")
    private List<Pessoa> persons;

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

	public List<Pessoa> getPersons() {
		return persons;
	}

	public void setPersons(List<Pessoa> persons) {
		this.persons = persons;
	}
 
    // get and set
}