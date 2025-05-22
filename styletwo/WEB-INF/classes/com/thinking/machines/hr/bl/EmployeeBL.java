package com.thinking.machines.hr.bl;
import java.text.*;
import com.thinking.machines.hr.dl.*;
import com.thinking.machines.hr.beans.*;
import java.util.*;

public class EmployeeBL
{
	public List<EmployeeBean> getAll()
	{
		List<EmployeeBean> employees=new LinkedList<>();
		try
		{
			EmployeeDAO employeeDAO = new EmployeeDAO();
			List<EmployeeDTO> dlEmployees = employeeDAO.getAll();
			EmployeeBean employeeBean;
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yy");
			for(EmployeeDTO dlEmployee:dlEmployees)
			{
				employeeBean=new EmployeeBean();
				employeeBean.setName(dlEmployee.getName());
				employeeBean.setEmployeeId(dlEmployee.getEmployeeId());
				employeeBean.setDesignationCode(dlEmployee.getDesignationCode());
				employeeBean.setDesignation(dlEmployee.getDesignation());
				employeeBean.setDateOfBirth(simpleDateFormat.format(dlEmployee.getDateOfBirth()));
				employeeBean.setGender(dlEmployee.getGender());
				employeeBean.setIsIndian(dlEmployee.getIsIndian());
				employeeBean.setBasicSalary(dlEmployee.getBasicSalary().toPlainString());
				employeeBean.setAadharCardNumber(dlEmployee.getAadharCardNumber());
				employeeBean.setPANNumber(dlEmployee.getPANNumber());
				employees.add(employeeBean);
			}
		}catch(DAOException e)
		{
			System.out.println(e.getMessage());
		}
		return employees;
	}
}