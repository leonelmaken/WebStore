package fr.koor.webstore.dao;

import javax.servlet.ServletContext;

public class DAOContext {
	
	protected static String dbURL;
	protected static String dbLogin;
	protected static String dbPassword;
	
	
	public static void init( ServletContext context ) {//récupère les informations du XML
		try {
			
			//Class.forName( "com.mysql.jdbc.Driver" );
			Class.forName( context.getInitParameter("JDBC_DRIVER") );
			dbURL = context.getInitParameter( "JDBC_URL" );
			dbLogin = context.getInitParameter( "JDBC_LOGIN" );
			dbPassword = context.getInitParameter( "JDBC_PASSWORD" );
			
			System.out.println("DAOContext: dbUrl: "+dbURL+", dbLogin: "+dbLogin+", dbPassword: "+dbPassword);
			
		} catch( Exception exception ) {
			
			exception.printStackTrace();
			
		}
	}
	
	
	
}
