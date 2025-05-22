package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddDesignation extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			HttpSession ss;
			ss=request.getSession();
			String user=(String)ss.getAttribute("username");
			if(user==null)
			{
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
				requestDispatcher.forward(request,response);
			}
			DesignationBean designationBean;
			designationBean=(DesignationBean)request.getAttribute("designationBean");	
			String title;
			
			title=designationBean.getTitle();
			DesignationDTO designation =new DesignationDTO();
			designation.setTitle(title);
			DesignationDAO designationDAO = new DesignationDAO();
			try
			{
				designationDAO.add(designation);
				designationBean.setCode(designation.getCode());
				MessageBean messageBean;
				messageBean= new MessageBean();
				messageBean.setHeading("Designation (Add Module)");
				messageBean.setMessage("Designation Added. add more ?");
				messageBean.setGenerateButtons(true);
				messageBean.setGenerateTwoButtons(true);
				messageBean.setButtonOneText("Yes");
				messageBean.setButtonOneAction("/DesignationAddForm.jsp");
				messageBean.setButtonTwoText("No");
				messageBean.setButtonTwoAction("/Designations.jsp");
				request.setAttribute("messageBean",messageBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
				requestDispatcher.forward(request,response);

			}catch(DAOException daoException)
			{
				ErrorBean errorBean;
				errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/DesignationAddForm.jsp");
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
		
	}
}
