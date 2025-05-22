<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</tm:ValidateUser>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/> 
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>		
<jsp:include page='/MainPageTop.jsp'/>
<script src='/styletwo/js/DesignationAddForm.js'></script>	
			<h2>Designation (Edit Module)</h2>
			<span class='error'>
				<jsp:getProperty name='errorBean' property='error' />
			</span>
		<form method='post' action='/styletwo/UpdateDesignation.jsp' onsubmit='return validate(this)'>
			Designation
			<input type='text' name='title' id='title' maxlength='35' value='${designationBean.title}'>
			<input type='hidden' name='code' id='title' value='${designationBean.code}'>  
			<span id='titleErrorSection' class='error'></span><br>
			<button type='submit'>Update</button>
			<button type='button' onclick='cancelEdit()'>Cancel</button>
		</form>
     	<br><br><br>
     	<form method='post' id='cancelEditForm' action='/styletwo/Designations.jsp'></form>
<jsp:include page='/MainPageBottom.jsp'/>