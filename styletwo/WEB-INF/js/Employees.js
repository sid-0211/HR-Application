function Employee()
{
	this.employeeId='';
	this.name='';
	this.designationCode=0;
	this.designation='';
	this.dateOfBirth='';
	this.gender='';
	this.isIndian=true;
	this.basicSalary=0;
	this.panNumber='';
	this.aadharCardNumber='';
}
var selectedRow=null;

var employees=[];

function selectEmployee(row,employeeId)
{
	if(selectedRow==row)return;
	if(selectedRow!=null)
	{
		selectedRow.style.background='white';
		selectedRow.style.color='black';
	}
	row.style.background='#7C7B7B';
	row.style.color='white';
	selectedRow=row;
	var i;
	for(i=0;i<employees.length;i++)
	{
		if(employees[i].employeeId==employeeId)
		{
			break;
		}
	}
	var emp=employees[i];
	document.getElementById("detailPanel_employeeId").innerHTML=emp.employeeId;
	document.getElementById("detailPanel_name").innerHTML=emp.name;
	document.getElementById("detailPanel_designation").innerHTML=emp.designation;
	document.getElementById("detailPanel_dateOfBirth").innerHTML=emp.dateOfBirth;
	document.getElementById("detailPanel_gender").innerHTML=emp.gender;
	if(emp.isIndian)
	{
		document.getElementById("detailPanel_isIndian").innerHTML="Yes";
	}
	else
	{
		document.getElementById("detailPanel_isIndian").innerHTML="No";
	}	
	document.getElementById("detailPanel_basicSalary").innerHTML=emp.basicSalary;
	document.getElementById("detailPanel_panNumber").innerHTML=emp.panNumber;
	document.getElementById("detailPanel_aadharCardNumber").innerHTML=emp.aadharCardNumber;
}
function createDynamicRowClickHandler(rowNumber,employeeId)
{
	return function()
	{
		selectEmployee(rowNumber,employeeId);
	};
}
function populateEmployeesGridTable()
{
	var gridTable=document.getElementById("employeesGridTable");
	var gridTableBody = gridTable.getElementsByTagName("tbody")[0];
	var gridTableBodyRow = gridTableBody.getElementsByTagName("tr")[0];

	//removing ROW from DOM(Document Object Model)
	gridTableBodyRow.remove();
	var gridTableBodyCell = gridTableBodyRow.getElementsByTagName("td");
	var cellTemplate;
	var dynamicRow;
	var dynamicRowCells;
	var placeHolderFor;
	for(var k=0;k<employees.length;k++)
	{
		dynamicRow=gridTableBodyRow.cloneNode(true);
		gridTableBody.appendChild(dynamicRow);
		dynamicRowCells=dynamicRow.getElementsByTagName("td");
		for(var i=0;i<dynamicRowCells.length;i++)
		{
			cellTemplate=dynamicRowCells[i];
			placeHolderFor=cellTemplate.getAttribute("placeHolderId");
			if(placeHolderFor==null)continue;
			if(placeHolderFor=="serialNumber") cellTemplate.innerHTML=(k+1)+".";
			if(placeHolderFor=="employeeId")cellTemplate.innerHTML=employees[k].employeeId;
			if(placeHolderFor=="name")cellTemplate.innerHTML=employees[k].name;
			if(placeHolderFor=="designationCode")cellTemplate.innerHTML=employees[k].designationCode;
			if(placeHolderFor=="designation")cellTemplate.innerHTML=employees[k].designation;
			if(placeHolderFor=="gender")cellTemplate.innerHTML=employees[k].gender;
			if(placeHolderFor=="isIndian")cellTemplate.innerHTML=employees[k].isIndian;
			if(placeHolderFor=="panNumber")cellTemplate.innerHTML=employees[k].panNumber;
			if(placeHolderFor=="aadharCardNumber")cellTemplate.innerHTML=employees[k].aadharCardNumber;
			if(placeHolderFor=="editOption")cellTemplate.innerHTML="<a href='/styletwo/editEmployee?code="+employees[k].employeeId+"'>Edit</a>";
			if(placeHolderFor=="deleteOption")cellTemplate.innerHTML="<a href='/styletwo/confirmDeleteEmployee?code="+employees[k].employeeId+"'>Delete</a>";
		}
		dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);
	}//employees number of times this loop will work
}
window.addEventListener('load',populateEmployeesGridTable);