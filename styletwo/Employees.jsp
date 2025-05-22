<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='si'%>
<si:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</si:ValidateUser>
<si:Module name='EMPLOYEE'/>


<jsp:include page='/MainPageTop.jsp'/>

<script src='/styletwo/js/Employees.js'></script>







<h2>Employees</h2>
<div class='div-for-employee-list'>
<table border='1' id='employeesGridTable'>
<thead>

<tr>
<th colspan='6' class='addEmp'><a href='/styletwo/EmployeesAddForm.jsp'>Add Employee</a></th>
</tr>


<tr>
<th class='empSNO'>S.No.</th>
<th class='empId'>Id</th>
<th class='empName'>Name</th>
<th class='empDesignation'>Designations</th>
<th class='empEdit'>Edit</th>
<th class='empDelete'>Delete</th>
</tr>
</thead>

<tbody>



<tr style='cursor:pointer' >

<td style='text-align:right' placeHolderId='serialNumber'></td>
<td placeHolderId='employeeId'></td>
<td placeHolderId='name'></td>
<td placeHolderId='designation'></td>
<td style='text-align:center' placeHolderId='editOption'></td>
<td style='text-align:center'placeHolderId='deleteOption'></td>
</tr>

</tbody>





</table>
</div>
<div style='border:1px solid black;margin-left:5px;height:25vh;margin-top:5px;margin-right:5px;margin-bottom:5px;padding:5px '>
<label style='background:gray;color:white;padding:0px 5px'>Details</label>
<table border='0' width="100%">
<tr>
	<td>Employee Id : <span id='detailPanel_employeeId' style='margin-right:30px'></td>
	<td>Name : <span id='detailPanel_name' style='margin-right:30px'></td>
	<td>Designation : <span id='detailPanel_designation' style='margin-right:30px'></td>
</tr>
<tr>
	<td>Date Of Birth : <span id='detailPanel_dateOfBirth' style='margin-right:30px'></td>
	<td>Gender : <span id='detailPanel_gender' style='margin-right:30px'></td>
	<td>Is Indian : <span id='detailPanel_isIndian' style='margin-right:30px'></td>
</tr>
<tr>
	<td>Basic Salary : <span id='detailPanel_basicSalary' style='margin-right:30px'></td>
	<td>Pan Number : <span id='detailPanel_panNumber' style='margin-right:30px'></td>
	<td>Aadhar Card Number : <span id='detailPanel_aadharCardNumber' style='margin-right:30px'></td>
</tr>
</table>


<jsp:include page='/MainPageBottom.jsp'/>



<%-- <tr style='cursor:pointer' onclick='selectEmployee(this,"${employeeB.employeeId}")'>
<td style='text-align:right'>${serialNumber}.</td>
<td>${employeeB.employeeId}</td>
<td>${employeeB.name}</td>
<td>${employeeB.designation}</td>
<td style='text-align:center'><a href='/styleone/editEmployee?code=${employeeB.employeeId}'>Edit</a></td>
<td style='text-align:center'><a href='/styleone/confirmDeleteEmployee?code=${employeeB.employeeId}'>Delete</a></td>
</tr> --%>



