package com.bridgelabz.servlets;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bridgelabz.pojo.Employee;

public class InsertServlet extends HttpServlet
{
	private SessionFactory factory;
	public void init()
	{
		try
		{
			//factory object creation with reference
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
			int empNo=Integer.parseInt(hreq.getParameter("empNo"));
			String empName=hreq.getParameter("empName");
			double empSal=Double.parseDouble(hreq.getParameter("empSal"));
			int deptNo=Integer.parseInt(hreq.getParameter("deptNo"));
			//starts session
			Session session=factory.openSession();
			Employee emp=new Employee();
			emp.setEmpNo(empNo);
			emp.setEmpName(empName);
			emp.setEmpSal(empSal);
			emp.setDeptNo(deptNo);
			//start transaction
			Transaction tx=session.beginTransaction();
			session.save(emp);
			tx.commit();
			PrintWriter pw=hres.getWriter();
			pw.print("<body bgcolor=cyan' text='blue'><h1><center>Employee Data saved successfully</center></h1></body>");
			pw.println("<br><a href='insert.html'>BACK</a>");
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