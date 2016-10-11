package com.samuel.testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.samuel.entidade.Pessoa;
import com.samuel.entidade.Brinquedo;
import com.samuel.entidade.Cachorro;
import com.samuel.entidade.Endereco;


public class Teste {

	public static void main(String[] args) {
        System.out.println("Iniciando CREATE");
        
        // Carregamento das configurações iniciais META-INF/persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("configlocal");
		EntityManager em = emf.createEntityManager();
		
 
        try {
            em.getTransaction().begin();
           
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////CREATE//////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            
            // Exemplo 1:1
            // Uma pessoa tem um endereço
            
            Pessoa samuel = new Pessoa("Samuel",21);
            Endereco enderecoSamuel = new Endereco("12225100","São José dos Campos","Jd. Americano","SP",35,"frente");
            samuel.setEndereco(enderecoSamuel);
           
            Pessoa caroline = new Pessoa("Caroline",21);
            Endereco enderecoCaroline = new Endereco("1122222","São José dos Campos","Centro","SP",10,"fundos");
            caroline.setEndereco(enderecoCaroline);
            
            Pessoa dallyane = new Pessoa("Dallyane",22);
            Endereco enderecoDallyane = new Endereco("555555","Tremembé","Centro","SP",10,"cela 23");
            dallyane.setEndereco(enderecoDallyane);

            Pessoa lucas = new Pessoa("Lucas",22);
            Endereco enderecoLucas = new Endereco("57572","Jd. Das Flores","Centro","SP",10,"cela 23");
            lucas.setEndereco(enderecoLucas);
            //////////////////////////
            // Exemplo N:M - Muitas pessoas podem ter muitos cachorros
        
            Cachorro pastorAlemao = new Cachorro("Hachi");
            
            Cachorro labrador = new Cachorro("Ralf");
       
            
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
            
            // Exemplo 1:N Um cachorro tem muitos brinquedos
            Brinquedo bola = new Brinquedo("Bola","Vermelha");
            bola.setCachorro(labrador);
            Brinquedo osso = new Brinquedo("Osso de Brinquedo","Branco");
            osso.setCachorro(labrador);
           
            List<Brinquedo> brinquedos = new ArrayList<Brinquedo>();
            brinquedos.add(bola);
            brinquedos.add(osso);
            
            labrador.setBrinquedos(brinquedos);
            
            

            
            
            em.persist(osso);
            em.persist(bola);
            em.persist(samuel);
            em.persist(caroline);
            em.persist(dallyane);
            em.persist(lucas);
            em.persist(labrador);
            em.persist(pastorAlemao);
          
            
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            ///////////READ///////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            System.out.println("Busca por ID no Endereço:");
            Endereco busca = em.find(Endereco.class, 1);
            
            System.out.println("O endereço encontrado foi: "+busca.getCep());
           
            System.out.println("Busca por WHERE LIKE %a%");
            List<Pessoa> result = (List<Pessoa>) em.createQuery("from Pessoa where name LIKE '%a%' ").getResultList();
            System.out.println("Lista de Resultados");
            for(Pessoa p:result){
            	System.out.println(p.getName());
            }
            
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////UPDATE//////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            System.out.println("Alteração do Endereço da Dallyane:");
            
    		em.merge(samuel);
    		enderecoDallyane.setCidade("Caçapava");
            dallyane.setEndereco(enderecoDallyane);
            
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////DELETE//////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            //////////////////////////
            System.out.println("Remoção da Pessoa Lucas:");
            em.remove(lucas);
            
            
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


