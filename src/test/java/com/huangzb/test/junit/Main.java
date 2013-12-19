package com.huangzb.test.junit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.huangzb.test.model.Person;

public class Main {
	private static final String PERSISTENCE_UNIT_NAME = "hibernatejpaPU";
	private static EntityManager em;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}

	@Test
	public void testInsert() {
		Person p = new Person();
		p.setId("id1");
		p.setName("name1");
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	@AfterClass
	public static void tearDownAfterClass(){
		em.close();
	}
}
