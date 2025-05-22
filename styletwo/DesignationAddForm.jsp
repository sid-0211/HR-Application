<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</tm:ValidateUser>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machines.hr.beans.DesignationBean'/> 
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>		
<jsp:include page='/MainPageTop.jsp'/>



			<script src='/styletwo/js/DesignationAddForm.js'></script>
			<h2>Designation (Add Module)</h2>
			<span class='error'>
				<jsp:getProperty name='errorBean' property='error' />
			</span>
		<form method='post' action='/styletwo/AddDesignation.jsp' onsubmit='return validate(this)'>
			Designation

			<input type='text' name='title' id='title' maxlength='35' value='${designationBean.title}'>
			<tm:FormId/>
			<span id='titleErrorSection' class='error'></span><br><br>
			<button type='submit'>Add</button>
			<button type='button' onclick='cancelAdd()'>Cancel</button>
		</form>
     	<br><br><br>
     	<form id='cancelAdditionForm' action='/styletwo/Designations.jsp'></form>
		<jsp:include page='/MainPageBottom.jsp'/>