package com.bridgelabz.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.dao.LoginDao;

@Controller
public class LoginController 

{
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping(value="loginpage",method=RequestMethod.GET)
	public ModelAndView getLoginPage()
	{
		return new ModelAndView("login","loginFormBackingObject",new Login());
	}

	@RequestMapping(value="check",method=RequestMethod.POST)
	public ModelAndView processRequest( @Valid @ModelAttribute("loginFormBackingObject")
	Login login, BindingResult result)
{
	if(result.hasErrors())
	
	 return new ModelAndView("login");
	
	else
	{
		boolean flag=loginDao.checkUser(login);
		if(flag)
		{
			return new  ModelAndView("success");
		}
		else
		{
			return new ModelAndView("failure");
		}
		
	}
}}

	
	



