<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</tm:ValidateUser>
<tm:Module name='EMPLOYEE'/>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean'/>
<jsp:setProperty name='employeeBean' property='*'/>
<jsp:forward page='/updateEmployee'/>
