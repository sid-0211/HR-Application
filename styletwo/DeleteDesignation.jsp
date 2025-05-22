<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</tm:ValidateUser>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
<jsp:setProperty name='designationBean' property='*' />
<jsp:forward page='/deleteDesignation' />