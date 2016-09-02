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

public class SelectServlet extends HttpServlet
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
			//fecting data from form
			PrintWriter pw=hres.getWriter();
			int empNo=Integer.parseInt(hreq.getParameter("empNo"));
			Session session=factory.openSession();
			Object o=session.get(Employee.class, empNo);
			if(o==null)
			{
				ServletContext context=hreq.getServletContext();
				RequestDispatcher rd=context.getRequestDispatcher("/select.html");
				rd.include(hreq, hres);
				pw.println("<br>Sorry..!Employee number not found<br>");
			}
			//Down-casting
			Employee emp=(Employee)o;
			
			//start transaction
			Transaction tx=session.beginTransaction();
			session.delete(emp);
			
			pw.print("<body bgcolor=cyan' text='blue'><center><h1><u>EMPLOYEE-DATA</u></h1>");
			pw.print("<table border='2'><tr><th>EmployeeNo</th><th>EmployeeName</th><th>EmployeeSalary</th><th>DeptNo</th></tr>");
			pw.print("<tr><td>"+emp.getEmpNo()+"</td>");
			pw.print("<td>"+emp.getEmpName()+"</td>");
			pw.print("<td>"+emp.getEmpSal()+"</td>");
			pw.print("<td>"+emp.getDeptNo()+"</td></tr>");
			pw.print("</table></center></body>");
			pw.println("<br><a href='select.html'>BACK</a>");
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