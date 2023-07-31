package org.jsp.PanAndPer;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchByNumberPan {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your pan card Number");
		long number=sc.nextLong();
		
		String qry="select p from PanCard p where p.number=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(qry);
		q.setParameter(1, number);

		try
		{
			PanCard p=(PanCard)q.getSingleResult();
			System.out.println("Id="+p.getId());
			System.out.println("Name="+p.getCity());
			System.out.println("Phone="+p.getNumber());
			System.out.println("Email="+p.getPincode());
		}
		catch(NoResultException e)
		{
			System.err.println("You have enter indalid number");
		}
		

	}

}
