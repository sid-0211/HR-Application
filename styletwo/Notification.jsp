<%@taglib uri='WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</tm:ValidateUser>
<jsp:useBean id='messageBean' scope='request' class='com.thinking.machines.hr.beans.MessageBean' />
<jsp:include page='/MainPageTop.jsp'/>



			<h2>${messageBean.heading}</h2>
			${messageBean.message}<br><br>
		



		<tm:If condition='${messageBean.generateButtons}'>
			<table>
			<tr>
			<td>
			<form action='/styletwo/${messageBean.buttonOneAction}'>
			<button type='submit'>${messageBean.buttonOneText} </button>
			</form>
			</td>
			
			<tm:If condition='${messageBean.generateTwoButtons}'>
			
			
				<td>
				<form action='/styletwo/${messageBean.buttonTwoAction}'>
				<button type='submit'>${messageBean.buttonTwoText} </button>
				</form>
				</td>

			</tm:If>

			</tr>
			</table>
		</tm:If>


		<jsp:include page='/MainPageBottom.jsp'/>

	