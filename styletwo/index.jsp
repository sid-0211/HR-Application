<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</tm:ValidateUser>
<tm:Module name='HOME'/>
<jsp:include page='/MainPageTop.jsp'/>
<H1>Welcome</H1>
<jsp:include page='/MainPageBottom.jsp'/>