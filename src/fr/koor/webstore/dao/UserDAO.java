package fr.koor.webstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import fr.koor.webstore.business.User;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.koor.webstore.business.User;
@SuppressWarnings("unused")
public class UserDAO extends DAOContext {

	public static User isValidLogin( String login, String password ) {
		
		try{
			
			System.out.println("UserDAO: dbUrl: "+dbURL+", dbLogin: "+dbLogin+", dbPassword: "+dbPassword);
//			Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword );
			Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword );
		String strSql = "SELECT * FROM T_Users WHERE login='" + login + "' AND password='" + password + "'";
			
			//String strSql = "SELECT * FROM T_Users WHERE login=? AND password=?";
			try ( Statement statement  = connection.createStatement() ) {
				try ( ResultSet resultSet = statement.executeQuery(strSql) ) {
					if ( resultSet.next() ) {
						return new User(
								resultSet.getInt( "idUser" ),
								resultSet.getString( "login" ),
								resultSet.getString( "password" ),
								resultSet.getInt("connectionNumber" )
						);
					} else {
						return null;
					}
				}
			}
		} catch ( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}
	
}
