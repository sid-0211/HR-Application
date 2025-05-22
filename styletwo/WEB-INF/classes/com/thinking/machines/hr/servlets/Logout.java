package com.thinking.machines.hr.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Logout extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession ss;
		ss=request.getSession();
		ss.removeAttribute("username");
		try
		{
			RequestDispatcher requestDispatcher;
			requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
			requestDispatcher.forward(request,response);
		}catch(Exception io)
		{
			//doNothing
		}
	}
}