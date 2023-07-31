package org.jsp.PanAndPer;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchPanCardByPersonPhEmail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your phone");
		long phone = sc.nextLong();
		System.out.println("Enter your email");
		String email = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry = "select p from Person p,PanCard pc where p.id=pc.id and p.phone=?1 and p.email=?2";
		Query q = manager.createQuery(qry);

//		Fetch Pan Card details by using person Phone and Email........................
		q.setParameter(1, phone);
		q.setParameter(2, email);

		try {
			Person p = (Person) q.getSingleResult();

			PanCard pc = p.getPcard();
			if (pc != null) {
				System.out.println("Person Email=" + p.getEmail());
				System.out.println("Person Name=" + p.getName());

				System.out.println(".........................");
				System.out.println("Pan Card ID=" + pc.getId());
				System.out.println("Pan Card number=" + pc.getNumber());
				System.out.println("Pan Card City=" + pc.getCity());
				System.out.println("Pan Card Pncode=" + pc.getPincode());

			} else {
				System.err.println("pan card details not exits for person email & phone");
			}

		} catch (NoResultException e) {
			System.err.println("Person data (phone & email) not persent in database");
		}

	}
}
