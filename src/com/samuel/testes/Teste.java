package com.samuel.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.samuel.entidade.Cliente;
import com.samuel.entidade.Dog;
import com.samuel.entidade.Endereco;
import com.samuel.repositorio.RepositorioCliente;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configlocal");
		EntityManager em = emf.createEntityManager();
 
        try {
            em.getTransaction().begin();
           
            // Exemplo 1 para 1 - Uma pessoa tem um Endereço
            Cliente samuel = new Cliente("Samuel",21);
            Endereco enderecoSamuel = new Endereco("12225100","São José dos Campos","Jd. Americano","SP",35,"");
            samuel.setEndereco(enderecoSamuel);
           
            Cliente caroline = new Cliente("Caroline",21);
            Endereco enderecoCaroline = new Endereco("1122222","São José dos Campos","Centro","SP",10,"");
            caroline.setEndereco(enderecoCaroline);

            // Exemplo N para M - Muitas pessoas podem ter muitos cachorros
        
            Dog pastorAlemao = new Dog();
            pastorAlemao.setName("Hachi");
            
            Dog labrador = new Dog();
            labrador.setName("Ralf");
            
            List<Dog> dogs = new ArrayList<Dog>();
            dogs.add(labrador);
            dogs.add(pastorAlemao);
            
            List<Cliente> donos = new ArrayList<Cliente>();
            donos.add(samuel);
            donos.add(caroline);
            
            samuel.setDogs(dogs);
            caroline.setDogs(dogs);
            labrador.setPersons(donos);
            pastorAlemao.setPersons(donos);
           
           
            //em.getTransaction().commit();
            em.persist(samuel);
            em.persist(caroline);
            em.persist(labrador);
            em.persist(pastorAlemao);

            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
 
        System.out.println("Fim");
    }
//		RepositorioCliente repositorioCliente = new RepositorioCliente();
//		Cliente cliente = new Cliente();
//
//		
//		
//		cliente.setName("Samuel Pereira");
//		cliente.setIdade(21);
//		
//		
//
//		repositorioCliente.salvar(cliente);
	}


