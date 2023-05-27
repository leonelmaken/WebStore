<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login screen</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
	<body>
        <h1>S'autnetifier</h1>
    
            <h2><%=  new Date()   %></h2>  
	
	    <form method="post" action="login">

	        <label for='txtLogin'>Login :</label><br> 
	        <input name="txtLogin" value="${login}" autofocus /><br>
            <label for='txtPassword'>Password :</label><br>
            <input name="txtPassword" type="password" value="${password}" /><br/><br>
	        <input type="submit" value="Connecter" />
	        <br/>
            <div class="errorMessage">${errorMessage}</div>
            
	    </form>
	    	
	</body>
</html>