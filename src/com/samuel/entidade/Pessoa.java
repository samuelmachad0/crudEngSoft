package com.samuel.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

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
@Table(name="pessoa")
@SequenceGenerator(name = "PESSOAS_SEQUENCE", sequenceName = "PESSOAS_SEQUENCE", allocationSize = 1, initialValue = 0)

public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pessoaId;
	
	@Column
	private String name;
	@Column
	private int idade;
	
	 @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	 @PrimaryKeyJoinColumn
	private Endereco endereco;
	
	 @ManyToMany
	 @JoinTable(name = "pessoa_cachorro", joinColumns = @JoinColumn(name = "pessoaId"), inverseJoinColumns = @JoinColumn(name = "cachorroId"))
	 private List<Cachorro> dogs;

	public Pessoa(String name, int idade){
		this.name = name;
		this.idade = idade;
	}
	public List<Cachorro> getDogs() {
		return dogs;
	}

	public void setDogs(List<Cachorro> dogs) {
		this.dogs = dogs;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	public int getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}


	
	

	
}
