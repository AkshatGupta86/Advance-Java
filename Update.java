package com.hql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update 
{
	private static final Object Id = null;

	public static void main(String[] args)throws IOException
	{
		Configuration configuration=new Configuration();
		configuration.configure("config.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query query;
		
		//InputStreamReader ir=new InputStreamReader();
		//BufferedReader br=new BufferedReader();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Name:");
		String Name=sc.nextLine();
		
		System.out.println("Enter Id to update from:");
		int i=sc.nextInt();
		
		query=session.createQuery("Update Student set name=:name where id=:id");
		query.setParameter("name", Name);
		query.setParameter("id", Id);
		
		int i1=query.executeUpdate();
		
		tx.commit();
		
		if(i1>0){
			System.out.println("Updated");
		}else{
			System.out.println("Not Updated");
		}
	}
}
