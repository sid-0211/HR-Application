package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;

public class Login extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{	
			AdministratorBean administratorBean;
			administratorBean= (AdministratorBean)request.getAttribute("administratorBean");
			if(administratorBean==null)
			{
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request,response);
			}
			
			try
			{
				AdministratorDAO administratorDAO = new AdministratorDAO();
				AdministratorDTO administrator;
				administrator=administratorDAO.getByUsername(administratorBean.getUsername());
				if(administrator.getPassword().equalsIgnoreCase(administratorBean.getPassword()))
				{
					HttpSession ss;
					ss=request.getSession();
					ss.setAttribute("username",administratorBean.getUsername());
					RequestDispatcher requestDispatcher;
					requestDispatcher=request.getRequestDispatcher("/index.jsp");
					requestDispatcher.forward(request,response);
				}
				else
				{
					ErrorBean errorBean;
					errorBean = new ErrorBean();
					errorBean.setError("Invalid Password");
					request.setAttribute("errorBean",errorBean);
					RequestDispatcher requestDispatcher;
					requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
					requestDispatcher.forward(request,response);
				}
			}catch(DAOException daoException)
			{	
				System.out.println(daoException.getMessage());
				ErrorBean errorBean;
				errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
				requestDispatcher.forward(request,response);
			}


		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		doPost(request,response);
	}
}