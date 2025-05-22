<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</tm:ValidateUser>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/> 
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>		
<jsp:include page='/MainPageTop.jsp'/>
			<script src='/styletwo/js/DesignationAddForm.js'></script>
			<h2>Designation (Delete Module)</h2>
			<span class='error'>
				<jsp:getProperty name='errorBean' property='error' />
			</span>
		<form method='post' action='/styletwo/DeleteDesignation.jsp' onsubmit='return validate(this)'>
			<input type='hidden' name='code' id='code' value='${designationBean.code}'>
			Designation : ${designationBean.title} <br><br>
			Are you sure you want to delete this designation ? <br><br><br>
			<button type='submit'>Yes</button>
			<button type='button' onclick='cancelDelete()'>No</button>
		</form>
     	<br><br><br>
     	<form method='post' id='cancelDeleteForm' action='/styletwo/Designations.jsp'></form>

<jsp:include page='/MainPageBottom.jsp'/>