package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import java.util.*;
import java.math.*;
import java.text.*;
import javax.servlet.http.*;

public class AddEmployee extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			System.out.println("Hello Cutie");
			HttpSession ss;
			ss=request.getSession();
			String user=(String)ss.getAttribute("username");
			if(user==null)
			{
				RequestDispatcher requestDispatcher;
				requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
				requestDispatcher.forward(request,response);
			}
			System.out.println("Hello Cutie");
			EmployeeBean employeeBean;
			employeeBean=(EmployeeBean)request.getAttribute("employeeBean");	
			String name;
			int designationCode;
			Date dateOfBirth;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String date;
			String gender;
			boolean isIndian;
			BigDecimal basicSalary;
			String aadharCardNumber,panNumber;


			name=employeeBean.getName();
			designationCode=employeeBean.getDesignationCode();
			date=employeeBean.getDateOfBirth();
			dateOfBirth=sdf.parse(date);
			gender=employeeBean.getGender();
			isIndian=employeeBean.getIsIndian();
			basicSalary=new BigDecimal(employeeBean.getBasicSalary());
			aadharCardNumber=employeeBean.getAadharCardNumber();
			panNumber=employeeBean.getPANNumber();

			EmployeeDTO employee = new EmployeeDTO();
			employee.setName(name);
			employee.setDesignationCode(designationCode);
			employee.setDateOfBirth(dateOfBirth);
			employee.setGender(gender);
			employee.setIsIndian(isIndian);
			employee.setBasicSalary(basicSalary);
			employee.setAadharCardNumber(aadharCardNumber);
			employee.setPANNumber(panNumber);

			EmployeeDAO employeeDAO = new EmployeeDAO();
			try
			{
				employeeDAO.add(employee);
				employeeBean.setEmployeeId(employee.getEmployeeId());
				MessageBean messageBean;
				messageBean= new MessageBean();
				messageBean.setHeading("Designation (Add Module)");
				messageBean.setMessage("Employee Added with Employee Id "+employeeBean.getEmployeeId()+". add more ?");
				messageBean.setGenerateButtons(true);
				messageBean.setGenerateTwoButtons(true);
				messageBean.setButtonOneText("Yes");
				messageBean.setButtonOneAction("/EmployeeAddForm.jsp");
				messageBean.setButtonTwoText("No");
				messageBean.setButtonTwoAction("/Employees.jsp");
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
				requestDispatcher=request.getRequestDispatcher("/EmployeesAddForm.jsp");
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
		System.out.println("Hello Cutie");
	}
}
