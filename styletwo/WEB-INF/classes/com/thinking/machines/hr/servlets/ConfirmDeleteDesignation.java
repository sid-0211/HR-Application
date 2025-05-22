package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfirmDeleteDesignation extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			boolean flag=false;
			HttpSession ss;
			ss=request.getSession();
			String user=(String)ss.getAttribute("username");
			System.out.println(user);
			if(user==null)
			{
				flag=true;
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
				requestDispatcher.forward(request,response);
			}
			if(flag==true)return;
			int code;
			String title;
			code=Integer.parseInt(request.getParameter("code"));
			DesignationDAO designationDAO=new DesignationDAO();
			try
			{
				DesignationDTO designation=designationDAO.getByCode(code);
				title=designation.getTitle();
				DesignationBean designationBean=new DesignationBean();
				designationBean.setTitle(title);
				designationBean.setCode(code);
				request.setAttribute("designationBean",designationBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/ConfirmDeleteDesignation.jsp");
				requestDispatcher.forward(request,response);
			}catch(DAOException daoException)
			{
				ErrorBean errorBean;
				errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/Designations.jsp");
				requestDispatcher.forward(request,response);
			}
		}catch(Exception e)
		{
			try
			{
				RequestDispatcher requestDispatcher;
				System.out.println(e);
				requestDispatcher = request.getRequestDispatcher("/Error.jsp");
				requestDispatcher.forward(request,response);
			}catch(Exception excpetion)
			{
				System.out.println(excpetion);
			}
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		doPost(request,response);
	}
}


/*
code

confirm delete designation 
	extract code and then fetch title from database
	if(valid)
		designationBean mai rakho 
		request.setAttribute("designationBean",designationBean)

delete confirmDeleteDesignation.jsp
	USEBean
	are you sure to delete this this title
	2 hidden form feilds
	Delete Cancel

deleteDesignation.jsp
3line


deleteDesignation
	extract from bean
	validate two feilds
	delete and create message bean
	Designation deleted !!
	OK -> /designations.jsp

*/








