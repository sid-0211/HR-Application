package com.thinking.machines.hr.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

public class ValidateUserTagHandler extends TagSupport
{
	private boolean flag=false;
	public int doStartTag()
	{
		try
		{
			String user=(String)pageContext.getAttribute("username",PageContext.SESSION_SCOPE);

			if(user==null)
			{
				flag=true;
				return super.EVAL_BODY_INCLUDE;
			}

		}catch(Exception io)
		{
			System.out.println(io.getMessage());
		}
		return super.SKIP_BODY;
	}
	public int doEndTag()
	{
		if(flag==true)
		{
			return super.SKIP_PAGE;
		}
		return super.EVAL_PAGE;
	}
}