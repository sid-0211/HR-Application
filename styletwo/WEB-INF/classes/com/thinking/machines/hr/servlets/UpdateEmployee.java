package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class UpdateEmployee extends HttpServlet
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
			System.out.println(flag);
			if(flag==true)return;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			EmployeeBean employeeBean;
			employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
			EmployeeDTO employeeDTO = new EmployeeDTO();

			employeeDTO.setEmployeeId(employeeBean.getEmployeeId());

			employeeDTO.setName(employeeBean.getName());

			employeeDTO.setDesignationCode(employeeBean.getDesignationCode());

			employeeDTO.setDateOfBirth(sdf.parse(employeeBean.getDateOfBirth()));

			employeeDTO.setGender(employeeBean.getGender());

			employeeDTO.setIsIndian(employeeBean.getIsIndian());

			employeeDTO.setBasicSalary(new BigDecimal(employeeBean.getBasicSalary()));

			employeeDTO.setAadharCardNumber(employeeBean.getEmployeeId());

			employeeDTO.setPANNumber(employeeBean.getPANNumber());

			
			EmployeeDAO employeeDAO = new EmployeeDAO();
			try
			{

				employeeDAO.update(employeeDTO);

				MessageBean messageBean;
				messageBean= new MessageBean();
				messageBean.setHeading("Employee (Edit Module)");
				messageBean.setMessage("Employee Updated");
				messageBean.setGenerateButtons(true);
				messageBean.setButtonOneText("OK");
				messageBean.setButtonOneAction("/Employees.jsp");
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
				requestDispatcher=request.getRequestDispatcher("/EmployeesEditForm.jsp");
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
