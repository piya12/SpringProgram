package com.bridgelabz.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bridgelabz.spring.Login;


@Repository(value="loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory factory;

	public boolean checkUser(Login login) {
		// TODO Auto-generated method stub
		Session session=factory.openSession();
		org.hibernate.Query qry=session.createQuery("select count(*) from Login l where l.uname =? and l.pwd=? ");
		qry.setParameter(0, login.getUname());
		qry.setParameter(1, login.getPwd());
		List list=qry.list();
		long cnt=0;
		if(!list.isEmpty())
		{
			cnt=(Long)list.get(0);
			if(cnt==1)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		else
		{
			return false;
		}
		
	}

}