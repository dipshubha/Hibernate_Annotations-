package org.jsp.PanAndPer;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchPersonByPancardNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Pan Card Number");
		long id = sc.nextLong();

//	Fetch Person details By pan Card Number..................................

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry = "select pc from Person p,PanCard pc where p.id=pc.id and pc.number=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);

//		Person p = (Person) q.getSingleResult();xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//    List<Person> p=q.getResultList();xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

		PanCard pc = (PanCard) q.getSingleResult();
		
		if (pc != null) {
			Person p = pc.getPerson();
			if (p != null) {
				System.out.println("Pan Card Number=" + pc.getNumber());
				System.out.println(".........................");
				System.out.println("Person ID=" + p.getId());
				System.out.println("Person Name=" + p.getName());
				System.out.println("Person Email=" + p.getEmail());
				System.out.println("Person Phone=" + p.getPhone());

			} else {
				System.err.println("No person exits for this Pan card");
			}
		} else {
			System.err.println("Pan card nit in BataBase");
		}

	}
}
