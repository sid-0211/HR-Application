package com.thinking.machines.hr.beans;
public class DesignationBean implements java.io.Serializable
{
	private int code;
	private String title;
	public DesignationBean()
	{
		code=0;
		title="";
	}
	public void setCode(int code)
	{
		this.code=code;
	}
	public int getCode()
	{
		return this.code;
	}
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return this.title;
	}
}