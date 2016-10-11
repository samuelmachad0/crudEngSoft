package com.samuel.entidade;
//Using the * to make the import list smaller
import javax.persistence.*;

@Entity
@Table(name="endereco")
@SequenceGenerator(name="USER_SEQUENCE", sequenceName="USER_SEQUENCE", allocationSize=1, initialValue=0)
public class Endereco{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int enderecoId;
	
	@Column
	private String cep;
	
	@Column
	private String cidade;
	
	@Column
	private String bairro;
	  
	@Column
	private String estado;
	  
	@Column
	private int numero;
	  
	@Column
	private String complemento;
	public Endereco(){
		
	}
	public Endereco(String cep,String cidade,String bairro,String estado,int numero,String complemento){
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.numero = numero;
		this.complemento = complemento;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getEnderecoId() {
		return enderecoId;
	}
	
	public void setEnderecoId(int enderecoId) {
		this.enderecoId = enderecoId;
	}
  
}