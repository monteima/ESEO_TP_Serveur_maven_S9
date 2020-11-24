package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCConfiguration {
	
		public static Connection getConnection() throws ClassNotFoundException{		

			Connection conn = null;
			
			String BDD = "ville_de_france";
	    	String url = "jdbc:mysql://localhost:3306/" + BDD;
	    	String user = "root";
	    	String passwd = "";
	    	java.sql.Statement st = null;
		    ResultSet rs = null;
			
			
        try {
        	
    	    Class.forName("com.mysql.jdbc.Driver");
    	    conn = DriverManager.getConnection(url, user, passwd);
    	    System.out.println("Connecté à la bdd");

        	
			} catch (SQLException e) {
	    	    e.printStackTrace();
	    	    System.out.println("Erreur");
	    	    System.exit(0);
			}
			return conn;
    }
}
