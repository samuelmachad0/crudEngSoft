package com.samuel.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@SequenceGenerator(name = "CUSTOMER_SEQUENCE", sequenceName = "CUSTOMER_SEQUENCE", allocationSize = 1, initialValue = 0)

public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQUENCE")
	private int clienteId;
	
	@Column
	private String name;
	@Column
	private int idade;
	
	 @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	 @PrimaryKeyJoinColumn
	private Endereco endereco;
	
	 @ManyToMany
	 @JoinTable(name = "person_dog", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "dog_id"))
	 private List<Dog> dogs;

	public Cliente(String name, int idade){
		this.name = name;
		this.idade = idade;
	}
	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


	
	

	
}
