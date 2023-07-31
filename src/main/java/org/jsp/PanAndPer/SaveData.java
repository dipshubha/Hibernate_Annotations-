package org.jsp.PanAndPer;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveData 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction tranasation =manager.getTransaction();
		Person p=new Person();
		p.setEmail("santra@gmail.com");
		p.setName("Santra");
		p.setPhone(89654321L);
		
		PanCard card=new PanCard();
		 card.setCity("Medinipur");
		 card.setCountry("India");
		 card.setDob(LocalDate.parse("1930-10-25"));
		 card.setNumber(987654);
		 card.setPincode(560067);
		 card.setState("wb");
		 
		 card.setPerson(p);
		 p.setPcard(card);
		 
		 manager.persist(p);
		 tranasation.begin();
		 tranasation.commit();
		 
		
		
	}

}
