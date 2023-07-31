package org.jsp.PanAndPer;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FeatchPanByPid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Pan Card id");
		int id = sc.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

// Fetch by pan Id.............................................................
		PanCard c = manager.find(PanCard.class, id);
		if (c != null) {
			Person person = c.getPerson();
			if (person != null) {
				System.out.println("Person ID=" + person.getId());
				System.out.println("Person Name=" + person.getName());
				System.out.println("Person Email=" + person.getEmail());
				System.out.println("Pan Card ID=" + person.getPcard());

			} else {
				System.err.println("No person found given thid Pan Card");

			}

		} else {
			System.err.println("card is not found");

		}

	}
}
