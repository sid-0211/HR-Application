package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.bl.*;
import com.thinking.machines.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class EmployeesJS extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
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
			PrintWriter pw = response.getWriter();
			response.setContentType("text/javascript");

			//The following line of code is a very bad idea 

			//File file=new File("c://tomcat9//webapps//styletwo//WEB-INF//js//Employees.js");

			ServletContext servletContext=getServletContext();
			File file=new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");
			RandomAccessFile randomAccessFile=new RandomAccessFile(file,"r");
			while(randomAccessFile.getFilePointer()<randomAccessFile.length())
			{
				pw.println(randomAccessFile.readLine());
			}
			randomAccessFile.close();

			List<EmployeeBean> employees=new EmployeeBL().getAll();
			pw.print("var employee;\n");
			int i=0; 

			//populating Employees in Employees Array declared in js file
			for(EmployeeBean employeeBean:employees)
			{
				pw.println("employee=new Employee();\n");
				pw.println("employee.employeeId=\""+employeeBean.getEmployeeId()+"\"\n");
				pw.println("employee.name=\""+employeeBean.getName()+"\"\n");
				pw.println("employee.designationCode=\""+employeeBean.getDesignationCode()+"\"\n");
				pw.println("employee.designation=\""+employeeBean.getDesignation()+"\"\n");
				pw.println("employee.dateOfBirth=\""+employeeBean.getDateOfBirth()+"\"\n");
				pw.println("employee.gender=\""+employeeBean.getGender()+"\"\n");
				pw.println("employee.isIndian=\""+employeeBean.getIsIndian()+"\"\n");
				pw.println("employee.basicSalary=\""+employeeBean.getBasicSalary()+"\"\n");
				pw.println("employee.panNumber=\""+employeeBean.getPANNumber()+"\"\n");
				pw.println("employee.aadharCardNumber=\""+employeeBean.getAadharCardNumber()+"\"\n");
				pw.println("employees["+i+"]=employee;\n");
				i++;
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		doGet(request,response);
	}
}
