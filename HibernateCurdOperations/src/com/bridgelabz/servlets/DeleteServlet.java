package com.bridgelabz.servlets;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.pojo.Employee;

public class DeleteServlet extends HttpServlet
{
	private SessionFactory factory;
	//non-life cycle init-method
	public void init()
	{
		try
		{
			//factory object creation
			factory=new Configuration().configure("com/bridgelabz/xmls/hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest hreq,HttpServletResponse hres)
	{
		try
		{
			PrintWriter pw=hres.getWriter();
			int empNo=Integer.parseInt(hreq.getParameter("empNo"));
			Session session=factory.openSession();
			//fetching the data form DB
			Object o=session.get(Employee.class, empNo);
			if(o==null)
			{
				ServletContext context=hreq.getServletContext();
				RequestDispatcher rd=context.getRequestDispatcher("/delete.html");
				rd.include(hreq, hres);
				pw.println("<br>Sorry..!Employee number not found<br>");
			}
			//Down-casting
			Employee emp=(Employee)o;
			
			//starts transaction
			Transaction tx=session.beginTransaction();
			session.delete(emp);
			tx.commit();
			
			pw.print("<body bgcolor=cyan' text='blue'><h1><center>Employee Deleted successfully</center></h1></body>");
			pw.println("<br><a href='delete.html'>BACK</a>");
			pw.close();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void destroy()
	{
		try
		{
			factory.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}