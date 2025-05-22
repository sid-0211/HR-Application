<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='si'%>
<si:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</si:ValidateUser>
<si:Module name='DESIGNATION'/>

<si:FormResubmitted>
<jsp:forward page='/notifyFormResubmission'/>
</si:FormResubmitted>

<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean' />
<jsp:setProperty name='designationBean' property='*' />
<jsp:forward page='/addDesignation' />