package com.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Insert 
{
	public static void main(String[] args)
	{
		Configuration configuration=new Configuration();
		configuration.configure("config.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
        
		Student b=new Student();
		b.setId(1);
		b.setName("Akshat");
		b.setSubject("Maths");
		b.setMarks(86);
		
		b.setId(2);
		b.setName("Akshat");
		b.setSubject("Maths");
		b.setMarks(86);
		
		session.save(b);
		
		//Getting data:-
		//String query="from Student";
		//Query q=session.createQuery(query);
		//List<Student> list=q.list();
		//for(Student student:list)
		//{
		//System.out.println(student.getId()+""+student.getName()+""+student.getSubject()+""+student.getMarks());
		//}
		tx.commit();
		System.out.println("Saved");
		session.close();
		
}
}