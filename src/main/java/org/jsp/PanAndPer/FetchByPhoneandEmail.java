package org.jsp.PanAndPer;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FetchByPhoneandEmail {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your phone");
		long phone=sc.nextLong();
		System.out.println("Enter your email");
		String email=sc.next();
		String qry="select p from Person p where p.phone=?1 and p.email=?2";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, email);

		try
		{
			Person p=(Person)q.getSingleResult();
			System.out.println("Id="+p.getId());
			System.out.println("Name="+p.getName());
			System.out.println("Phone="+p.getPhone());
			System.out.println("Email="+p.getEmail());
		}
		catch(NoResultException e)
		{
			System.err.println("You have enter indalid Phone @ email");
		}
		

	}

}
