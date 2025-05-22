<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:ValidateUser>
	<jsp:forward page='/LoginForm.jsp'/>
</tm:ValidateUser>
<tm:Module name='EMPLOYEE'/>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machines.hr.beans.EmployeeBean'/> 
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machines.hr.beans.ErrorBean'/>		
<jsp:include page='/MainPageTop.jsp'/>
<script src='/styletwo/js/DesignationAddForm.js'></script>	
			<h2>Employee (Edit Module)</h2>
        <span class='error'>
                <jsp:getProperty name='errorBean' property='error' />
        </span>
        <form action='/styletwo/UpdateEmployee.jsp' method="post" onsubmit='return validate(this)'>
            <table>
                <tr>
                    <td>
                        Name
                    </td>
                    <td>
                        <input type='text' name='name' id='name' maxlength='49' size='50' value="${employeeBean.name}">
                        <span id='nameErrorSection' style='color:red'></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        Designation
                    </td>
                    <td>
                        <select id='designationCode' name='designationCode' value="${employeeBean.designationCode}">
                            <option value='-1'> &lt;Select Designation &gt;</option>
                            
                        </select>   
                        <span id='designationCodeErrorSection' style='color:red'></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        Date Of Birth
                    </td>
                    <td>
                        <input type='date' id='dateOfBirth' name='dateOfBirth' value="${employeeBean.dateOfBirth}">
                        <span id='dateOfBirthErrorSection' style='color:red'></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender
                    </td>
                    <td>
                        <input type='radio' value='M' name='gender' id='male' ${employeeBean.gender == 'M' ? 'checked' : ''}>Male &nbsp;&nbsp;&nbsp;
<input type='radio' value='F' name='gender' id='female' ${employeeBean.gender == 'F' ? 'checked' : ''}>Female
                        <span id='genderErrorSection' style='color:red'></span>
                    </td>
                </tr>
                <tr>    
                    <td>
                        Indian ?
                    </td>
                    <td>    
                        <input type='checkbox' name='isIndian' id='isIndian' value='true' ${employeeBean.isIndian ? 'checked' : ''}>
                    </td>
                </tr>
                    <td>
                        Basic Salary
                    </td>
                    <td>
                        <input type='text' style='text-align:right' name='basicSalary' id='basicSalary' value="${employeeBean.basicSalary}">
                        <span id='basicSalaryErrorSection' style='color:red'></span>
                    </td>
                <tr>
                    <td>
                        Aadhar Card Number
                    </td>
                    <td>
                        <input type='text' id='aadharCardNumber' name='aadharCardNumber' value="${employeeBean.aadharCardNumber}">
                        <span id='aadharCardNumberErrorSection' style='color:red'></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        Pan Number
                    </td>
                    <td>
                        <input type='text' id='panNumber' name='PANNumber' value="${employeeBean.PANNumber}">
                        <span id='panNumberErrorSection' style='color:red'></span>
                    </td>
                </tr>
                <tr>
                    <td colspan='2'>
                        <button type='submit'>Update</button>&nbsp;
                        <button type='button' id='cancelUpdateForm'>Cancel</button>
                    </td>
                </tr>
                <input type='hidden' id='employeeId' name='employeeId' value="${employeeBean.employeeId}">
            </table>
        </form>
     	<br><br><br>
     	<form method='post' id='cancelEditForm' action='/styletwo/Employees.jsp'></form>
     	<script>
     function validate(frm)
        {
            var firstInvalidComponent=null;
            var valid=true;
            var name = frm.name.value.trim();
            var nameErrorSection = document.getElementById('nameErrorSection');
            nameErrorSection.innerHTML='';
            if(name.length==0)
            {
                nameErrorSection.innerHTML='Name required';
                valid=false;
                if(firstInvalidComponent==null)firstInvalidComponent=frm.name;
            }

            var designationCode = frm.designationCode.value.trim();
            var designationCodeErrorSection = document.getElementById('designationCodeErrorSection');
            designationCodeErrorSection.innerHTML='';
            if(designationCode==-1)
            {
                designationCodeErrorSection.innerHTML='Select designation';
                valid=false;
                if(firstInvalidComponent==null)firstInvalidComponent=frm.designationCode;
            } 


            var dateOfBirth = frm.dateOfBirth.value;
            var dateOfBirthErrorSection = document.getElementById('dateOfBirthErrorSection');
            dateOfBirthErrorSection.innerHTML='';
            if(dateOfBirth.length==0)
            {
                dateOfBirthErrorSection.innerHTML='Select date of birth';
                valid=false;
                if(firstInvalidComponent==null)firstInvalidComponent=frm.dateOfBirth;
            } 


            var genderErrorSection = document.getElementById('genderErrorSection');
            genderErrorSection.innerHTML='';
            if(frm.gender[0].checked==false && frm.gender[1].checked==false)
            {
                genderErrorSection.innerHTML='Select gender';
                valid=false;
            }
            
            var basicSalary = frm.basicSalary.value.trim();
            var basicSalaryErrorSection = document.getElementById('basicSalaryErrorSection');
            basicSalaryErrorSection.innerHTML='';
            if(basicSalary.length==0)
            {
                basicSalaryErrorSection.innerHTML='Salary required';
                valid=false;
                if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;
            }
            else
            {
                var v="1234567890.";
                var e =0;
                var isBasicSalaryValid=true;
                while(e<basicSalary.length)
                {
                    if(v.indexOf(basicSalary.charAt(e))==-1)
                    {
                        basicSalaryErrorSection.innerHTML='Invalid Basic Salary';
                        valid=false;
                        isBasicSalaryValid=false;
                        if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;    
                    }

                    e++;
                }
                if(isBasicSalaryValid)
                {
                    var dot = basicSalary.indexOf('.');
                    if(dot!=-1)
                    {
                        var numberOfFractions=basicSalary.length-(dot+1);
                        if(numberOfFractions>2)
                        {
                            basicSalaryErrorSection.innerHTML='Invalid Basic Salary';
                            valid=false;
                            if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;
                        }
                    }
                }


            }
            var aadharCardNumber = frm.aadharCardNumber.value.trim();
            var aadharCardNumberErrorSection = document.getElementById('aadharCardNumberErrorSection');
            aadharCardNumberErrorSection.innerHTML='';
            if(aadharCardNumber.length==0)
            {
                aadharCardNumberErrorSection.innerHTML='required';
                valid=false;

                if(firstInvalidComponent==null)firstInvalidComponent=frm.aadharCardNumber;
            }

        
            var panNumber = frm.panNumber.value.trim();
            var panNumberErrorSection = document.getElementById('panNumberErrorSection');
            panNumberErrorSection.innerHTML='';
            if(panNumber.length==0)
            {
                panNumberErrorSection.innerHTML='required';
                valid=false;
                if(firstInvalidComponent==null)firstInvalidComponent=frm.panNumber;
            }
            
            if(!valid)firstInvalidComponent.focus();
            return valid;
        }
        function cancelUpdate()
        {
            document.getElementById('cancelUpdateForm').submit();
        }
function populateDesignations()
{
    var selectedDesignationCode = "${employeeBean.designationCode}"; // JSP EL evaluates on server
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function()
    {
        if(this.readyState == 4)
        {
            if(this.status == 200)
            {
                var responseData = this.responseText;
                var designationsComboBox = document.getElementById("designationCode");
                var obj;
                var splits = responseData.split(",");
                for(var i = 0; i < splits.length; i += 2)
                {
                    obj = document.createElement("option");
                    obj.value = splits[i];
                    obj.text = splits[i+1];
                    if(obj.value === selectedDesignationCode) obj.selected = true;
                    designationsComboBox.appendChild(obj);
                }
            }
            else
            {
                alert("Some problem occurred while loading designations.");
            }
        }
    };
    xmlHttpRequest.open('GET', 'servletOne', true);
    xmlHttpRequest.send();
}
window.addEventListener('load', populateDesignations);
</script>
<jsp:include page='/MainPageBottom.jsp'/>