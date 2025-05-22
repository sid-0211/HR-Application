<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='si'%>
<si:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</si:ValidateUser>
<si:Module name='EMPLOYEE'/>

<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean' />
<jsp:setProperty name='employeeBean' property='*' />
<jsp:forward page='/addEmployee' />