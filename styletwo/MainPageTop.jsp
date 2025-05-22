<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
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

<div style='width:45hw;height:auto;border:1px solid black;margin:5px'>



<a href='/styletwo'><img src='/styletwo/images/logo.png' class='logo'></a><div class='brand-name'>Siddharth Industries


<a class='logout' href='/styletwo/logout'>Logout</a>
<small class='admin-name'>${username}</small>

<img class='user-logo' src='/styletwo/images/user.png'>


</div>




</div>
<!--header ends here-->
<!--content starts here-->
<div class='content'>
<!--left panel starts here-->
<div class='content-left-panel'>


<tm:If condition='${module==DESIGNATION}'>
<b>Designations</b><br>
</tm:If>
<tm:If condition='${module!=DESIGNATION}'>
<a href='/styletwo/Designations.jsp'>Designations</a><br>
</tm:If>
<tm:If condition='${module==EMPLOYEE}'>
<b>Employees</b><br>
</tm:If>
<tm:If condition='${module!=EMPLOYEE}'>
<a href='/styletwo/Employees.jsp'>Employees</a><br>
</tm:If>
<tm:If condition='${module!=HOME}'>
	<br>
<a href='/styletwo/index.jsp'>Home</a>
</tm:If>


</div>
<!--left panel ends here-->
<!--right panel starts here-->
<div class='content-right-panel'>
	