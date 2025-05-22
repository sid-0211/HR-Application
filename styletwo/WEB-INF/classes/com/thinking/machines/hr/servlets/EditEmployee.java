package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class EditEmployee extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
			String empId;
			empId=request.getParameter("code");
			EmployeeDAO employeeDAO=new EmployeeDAO();
			EmployeeDTO employeeDTO;

			try
			{
				employeeDTO= employeeDAO.getByEmployeeId(empId);
				EmployeeBean employeeBean= new EmployeeBean();

				employeeBean.setEmployeeId(empId);
				employeeBean.setName(employeeDTO.getName());
				employeeBean.setDesignationCode(employeeDTO.getDesignationCode());
				String date = sdf.format(employeeDTO.getDateOfBirth());

				employeeBean.setDateOfBirth(date);
				employeeBean.setGender(employeeDTO.getGender());
				employeeBean.setIsIndian(employeeDTO.getIsIndian());

				employeeBean.setBasicSalary(employeeDTO.getBasicSalary().toPlainString());
				employeeBean.setPANNumber(employeeDTO.getPANNumber());
				employeeBean.setAadharCardNumber(employeeDTO.getAadharCardNumber());



				request.setAttribute("employeeBean",employeeBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/EmployeeEditForm.jsp");
				requestDispatcher.forward(request,response);

			}catch(DAOException daoException)
			{
				ErrorBean errorBean;
				errorBean = new ErrorBean();
				errorBean.setError(daoException.getMessage());
				request.setAttribute("errorBean",errorBean);
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/Employees.jsp");
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
