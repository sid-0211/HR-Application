<jsp:useBean id='administratorBean' scope='request' class='com.thinking.machines.hr.beans.AdministratorBean'/>
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>
<!DOCTYPE HTML>
<html lang='en'>
<head> 
<title>Siddharth Industries</title>
<meta charset='utf=8'>
<link rel="stylesheet" href="/styletwo/css/styles.css">
</head>
<body>
<!--Main container starts here-->
<div class='main-container'>
<!--header starts here-->
<div style='width:90hw;height:auto;border:1px solid black;margin:5px'>
<a href='/styletwo'><img src='/styletwo/images/logo.png' class='logo'></a><div class='brand-name'>Siddharth Industries</div>
</div>
<!--header ends here-->


<div style='width:50hw;height:390px;border:1px solid black;margin:5px;padding:5px'>
<h2 style='text-align:center;'>Administrator</h2>
<div style='width:220px;border:1px solid black;margin:5px;padding:50px;margin:0px 0px 50px 340px'>
	<span class='error'><jsp:getProperty name='errorBean' property='error' /></span>
	<form action='/styletwo/Login.jsp'>

		<table>
			<tr>
				<td>
		Username:
				</td>
				<td>
		<input type='text' name='username' id='username' value='${administratorBean.username}'><br>
				</td>
			</tr>
			<tr>
				<td>
		Password:
				</td>
				<td>
		<input type='password' name='password' id='password' value='${administratorBean.password}'><br>
				</td>
			</tr>
		</table><br>
		<button type='submit'>Login</button>
	
	</form>
</div>
</div>


<!--Footer starts here-->
<div class='footer'>
&copy;Siddharth Industries 2020
</div>
<!--Footer ends here-->
</div>
<!--Main container ends here-->
</body>
<script src='/styletwo/js/DesignationAddForm.js'/>
</html>



