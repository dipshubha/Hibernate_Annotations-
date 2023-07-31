package org.jsp.PanAndPer;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchPerson {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Id");
		int id = sc.nextInt();

		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p = manager.find(Person.class, id);

		if (p != null) {
			System.out.println("Id=" + p.getId());
			System.out.println("Name=" + p.getName());
			System.out.println("Name=" + p.getEmail());
			System.out.println("Name=" + p.getPhone());


		} else {
			System.err.println("Entered id not exist in database");
		}

	}

}
