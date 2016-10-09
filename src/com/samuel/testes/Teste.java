package com.samuel.testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.samuel.entidade.Pessoa;
import com.samuel.entidade.Cachorro;
import com.samuel.entidade.Endereco;


public class Teste {

	public static void main(String[] args) {
        System.out.println("Iniciando Operações");
        
        // Carregamento das configurações iniciais META-INF/persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configlocal");
		EntityManager em = emf.createEntityManager();
 
        try {
            em.getTransaction().begin();
           
            // Exemplo 1:1
            // Uma pessoa tem um endereço
            
            Pessoa samuel = new Pessoa("Samuel",21);
            Endereco enderecoSamuel = new Endereco("12225100","São José dos Campos","Jd. Americano","SP",35,"");
            samuel.setEndereco(enderecoSamuel);
           
            Pessoa caroline = new Pessoa("Caroline",21);
            Endereco enderecoCaroline = new Endereco("1122222","São José dos Campos","Centro","SP",10,"");
            caroline.setEndereco(enderecoCaroline);
            //////////////////////////
            // Exemplo N:M - Muitas pessoas podem ter muitos cachorros
        
            Cachorro pastorAlemao = new Cachorro();
            pastorAlemao.setName("Hachi");
            
            Cachorro labrador = new Cachorro();
            labrador.setName("Ralf");
            
            List<Cachorro> dogs = new ArrayList<Cachorro>();
            dogs.add(labrador);
            dogs.add(pastorAlemao);
            
            List<Pessoa> donos = new ArrayList<Pessoa>();
            donos.add(samuel);
            donos.add(caroline);
            
            samuel.setDogs(dogs);
            caroline.setDogs(dogs);
            labrador.setPersons(donos);
            pastorAlemao.setPersons(donos);
           
           
           
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

	}


