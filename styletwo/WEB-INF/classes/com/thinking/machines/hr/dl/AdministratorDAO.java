package com.thinking.machines.hr.dl;
import com.thinking.machines.hr.dl.*;
import java.sql.*;
public class AdministratorDAO 
{
	public AdministratorDTO getByUsername(String username) throws  DAOException
	{
		try
		{
			Connection connection =DAOConnection.getConnection();
			PreparedStatement preparedStatement;
			preparedStatement= connection.prepareStatement("select * from administrator where uname=?");
			preparedStatement.setString(1,username);
			ResultSet resultSet;
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()==false)
			{
				resultSet.close();
				preparedStatement.close();
				connection.close();
				throw new DAOException("Invalid Username: "+username);
			}
			AdministratorDTO administratorDTO=new AdministratorDTO();
			administratorDTO.setPassword(resultSet.getString("pwd").trim());
			administratorDTO.setUsername(resultSet.getString("uname").trim());
			resultSet.close();
			preparedStatement.close();
			connection.close();
			return administratorDTO;
		}catch(Exception exception)
		{
			throw new DAOException(exception.getMessage());
		}
	}
}
