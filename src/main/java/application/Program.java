package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Pessoa;

public class Program {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-example");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Pessoa p1 = new Pessoa(null, "Alex", "brunno@gmail.com");
		em.persist(p1);
		System.out.println("Done");
		
		Pessoa p2 = em.find(Pessoa.class, 6);
		em.remove(p2);
		System.out.println("Done");
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
