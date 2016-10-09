package com.samuel.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Brinquedo {
	@Id
    @GeneratedValue
    private int brinquedoId;
 
    @ManyToOne
    @JoinColumn(name = "cachorro_id")
    private Cachorro cachorro;
    
    @Column
    private String nome;
    private String cor;
    
    public Brinquedo(String nome, String cor){
    	this.nome = nome;
    	this.cor = cor;
    }
	public int getBrinquedoId() {
		return brinquedoId;
	}
	public void setBrinquedoId(int brinquedoId) {
		this.brinquedoId = brinquedoId;
	}
	public Cachorro getCachorro() {
		return cachorro;
	}
	public void setCachorro(Cachorro cachorro) {
		this.cachorro = cachorro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
}
