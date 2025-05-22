<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='si'%>
<si:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</si:ValidateUser>
<si:Module name='DESIGNATION'/>


<jsp:include page='/MainPageTop.jsp'/>
<h2>Designations</h2>
<table border='1'>
<thead>
<tr>
<th colspan='4' style='text-align:right;padding:5px'><a href='/styletwo/DesignationAddForm.jsp'>Add new designation</a></th>
</tr>
<tr>
<th class='designationSNO'>S.No.</th>
<th class='designationT'>Designations</th>
<th class='designationEdit'>Edit</th>
<th class='designationDelete'>Delete</th>
</tr>
</thead>
<si:EntityList populatorClass='com.thinking.machines.hr.bl.DesignationBL' populatorMethod='getAll' name='dBean'>
<tr>
<td class='tdserial'>${serialNumber}.</td>
<td>${dBean.title}</td>
<td class='tdEdit'><a href='/styletwo/editDesignation?code=${dBean.code}'>Edit</a></td>
<td class='tdDelete'><a href='/styletwo/confirmDeleteDesignation?code=${dBean.code}'>Delete</a></td>
</tr>
</si:EntityList>
</table>

<jsp:include page='/MainPageBottom.jsp'/>
