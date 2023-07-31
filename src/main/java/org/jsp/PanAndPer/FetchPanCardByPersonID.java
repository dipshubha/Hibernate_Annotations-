
package org.jsp.PanAndPer;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FetchPanCardByPersonID {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Person id");
		int id = sc.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		// Fetch Pan Card details using Person id.....................................
		Person p = manager.find(Person.class, id);
		if (p != null) {
			PanCard pc = p.getPcard();
			if (pc != null) {
				System.out.println("Person Name=" + p.getName());
				System.out.println(".........................");
				System.out.println("Pan card ID=" + pc.getId());
				System.out.println("Pan card Name=" + pc.getNumber());
				System.out.println("Pan acrd city=" + pc.getCity());
				System.out.println("Pan card country=" + pc.getCountry());
				System.out.println("Pan Card pincode=" + pc.getPincode());

			}
			else
			{
				System.err.println("No Pan Card found for this Person");
			}
		}
		else {
			System.err.println("Person not exist in database");
		}

	}

}
