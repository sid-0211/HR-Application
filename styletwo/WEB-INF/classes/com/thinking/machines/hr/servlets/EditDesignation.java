package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditDesignation extends HttpServlet
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
			code=Integer.parseInt(request.getParameter("code"));
			DesignationDAO designationDAO = new DesignationDAO();
			DesignationDTO designationDTO;
			try
			{
				designationDTO = designationDAO.getByCode(code);
				DesignationBean designationBean = new DesignationBean();
				designationBean.setTitle(designationDTO.getTitle());
				designationBean.setCode(designationDTO.getCode());
				request.setAttribute("designationBean",designationBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
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
