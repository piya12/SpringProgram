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

public class UpdateServlet extends HttpServlet
{
	private SessionFactory factory;
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
			//reading data from form
			PrintWriter pw=hres.getWriter();
			int empNo=Integer.parseInt(hreq.getParameter("empNo"));
			String empName=hreq.getParameter("empName");
			double empSal=Double.parseDouble(hreq.getParameter("empSal"));
			int deptNo=Integer.parseInt(hreq.getParameter("deptNo"));
			Session session=factory.openSession();
			//fetching data form DB
			Object o=session.get(Employee.class, empNo);
			if(o==null)
			{
				ServletContext context=hreq.getServletContext();
				RequestDispatcher rd=context.getRequestDispatcher("/update.html");
				rd.include(hreq, hres);
				pw.println("<br>Sorry..!Employee number not found<br>");
			}
			//Down-casting
			Employee emp=(Employee)o;
			Transaction tx=session.beginTransaction();
			//setting data to the employee Object
			emp.setEmpName(empName);
			emp.setEmpSal(empSal);
			emp.setDeptNo(deptNo);
			tx.commit();
			
			pw.println("<body bgcolor=cyan' text='blue'><h1><center>Employee Data updated successfully</center></h1></body>");
			pw.println("<br><a href='update.html'>BACK</a>");
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