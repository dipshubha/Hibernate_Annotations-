package org.jsp.PanAndPer;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchByName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = sc.next();
		String qry = "select p from Person p where p.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createQuery(qry);
        q.setParameter(1, name);
        List<Person> p=q.getResultList();
        if(p.size()>0)
        {
        	for(Person p1:p)
        	{
        		System.out.println("Id="+p1.getId());
    			System.out.println("Name="+p1.getName());
    			System.out.println("Phone="+p1.getPhone());
    			System.out.println("Email="+p1.getEmail());

        	}
        }
	}

}
