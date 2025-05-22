function validate(frm)
{
	var title = frm.title.value.trim();
	var titleErrorSection = document.getElementById('titleErrorSection');
	titleErrorSection.innerHTML='';
	if(title.length==0)
	{
		titleErrorSection.innerHTML='Required';
		frm.title.focus();
		return false;
	}
	return true;
}
function cancelAdd()
{
	document.getElementById('cancelAdditionForm').submit();
}
function cancelDelete()
{
	document.getElementById('cancelDeleteForm').submit();
}
function cancelEdit()
{
	document.getElementById('cancelEditForm').submit();
}