package com.hql;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete 
{
public static void main(String[] args)throws IOException{
	Configuration configuration=new Configuration();
	configuration.configure("config.xml");
	SessionFactory sessionFactory=configuration.buildSessionFactory();
	Session session=sessionFactory.openSession();
	Transaction tx=session.beginTransaction();
	Query query;
	
    InputStreamReader ir=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(ir);
    System.out.println("Enter Id to Delete:");
    
    int id=Integer.parseInt(br.readLine());
    query = session.createQuery("Delete from Student where id=:id");
    query.setParameter("id",id);
    int i=query.executeUpdate();
    tx.commit();
    if(i>0){
    	System.out.println("Deleted");
    }
    else
    {
    	System.out.println("Not Deleted");	
    }
    session.close();
   }
}