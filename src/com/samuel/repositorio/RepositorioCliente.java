package com.samuel.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.samuel.entidade.Cliente;



public class RepositorioCliente {
	
	EntityManagerFactory emf;
	EntityManager em;
	public RepositorioCliente(){
		emf = Persistence.createEntityManagerFactory("configsamuel");
		em = emf.createEntityManager();
		
	}
	public void salvar(Cliente cliente){
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		emf.close();
	}
	
	public void remover(Cliente cliente){
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
		emf.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select cliente from Cliente cliente");
		List<Cliente> clientes = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return clientes;
	}
	
}
