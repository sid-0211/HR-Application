package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteDesignation extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			boolean flag=false;
			HttpSession ss;
			ss=request.getSession();
			String user=(String)ss.getAttribute("username");
			if(user==null)
			{
				flag=true;
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
				requestDispatcher.forward(request,response);
			}
			if(flag==true)return;
			DesignationBean designationBean;
			designationBean=(DesignationBean)request.getAttribute("designationBean");
			int code=designationBean.getCode();
			DesignationDTO designation =new DesignationDTO();
			DesignationDAO designationDAO = new DesignationDAO();
			try
			{
				designationDAO.deleteByCode(code);
				MessageBean messageBean;
				messageBean= new MessageBean();
				messageBean.setHeading("Designation (Delete Module)");
				messageBean.setMessage("Designation Deleted");
				messageBean.setGenerateButtons(true);
				messageBean.setButtonOneText("OK");
				messageBean.setButtonOneAction("Designations.jsp");
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
				requestDispatcher=request.getRequestDispatcher("/DesignationEditForm.jsp");
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
