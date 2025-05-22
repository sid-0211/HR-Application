package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NotifyFormResubmission extends HttpServlet
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
				MessageBean messageBean;
				messageBean= new MessageBean();
				messageBean.setHeading("Notification !!!");
				messageBean.setMessage("Do Not Reload the Page While Using the application");
				messageBean.setGenerateButtons(true);
				messageBean.setButtonOneText("OK");
				messageBean.setButtonOneAction("Designations.jsp");
				request.setAttribute("messageBean",messageBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/Notification.jsp");
				requestDispatcher.forward(request,response);

			
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
