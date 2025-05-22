package com.thinking.machines.hr.dl;
import java.util.*;
import java.io.*;

public class AdministratorDTO implements Serializable,Comparable<AdministratorDTO>
{
	private String username;
	private String password;
	public AdministratorDTO()
	{
		this.username="";
		this.password="";
	}
	public String getUsername()
	{
		return this.username;
	}
	public void setUsername(String username)
	{
		this.username=username;
	}

	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}

	public boolean equals(Object object)
	{
		if(!(object instanceof AdministratorDTO))return false;
		AdministratorDTO other=(AdministratorDTO)object;
		return other.username.equalsIgnoreCase(this.username);
	}
	public int compareTo(AdministratorDTO other)
	{
		return this.username.compareToIgnoreCase(other.username);
	}
	public int hashCode()
	{
		return username.hashCode();
	}
}