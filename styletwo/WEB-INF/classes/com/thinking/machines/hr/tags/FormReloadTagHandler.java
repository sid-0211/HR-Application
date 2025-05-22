package com.thinking.machines.hr.tags;
import java.io.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.util.*;
public class FormReloadTagHandler extends TagSupport
{
	public int doStartTag()
	{
		String formId=UUID.randomUUID().toString();
		pageContext.setAttribute(formId,formId,PageContext.SESSION_SCOPE);
		JspWriter jw =pageContext.getOut();
		try
		{
			jw.print("<input type='hidden' id='formId' name='formId' value='"+formId+"'>");
		}catch(IOException io)
		{
			System.out.println(io.getMessage());
		}
		return super.SKIP_BODY;
	}
	public int doEndTag()
	{

		return super.EVAL_PAGE;
	}
}