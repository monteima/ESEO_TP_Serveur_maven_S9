package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConfiguration {
	
		public static Connection getConnection() throws ClassNotFoundException{		

			Connection conn = null;
			
			String bdd = "ville_de_france";
	    	String url = "jdbc:mysql://localhost:3306/" + bdd;
	    	String user = "root";
	    	String passwd = "";
			
			
        try {
        	
    	    Class.forName("com.mysql.jdbc.Driver");
    	    conn = DriverManager.getConnection(url, user, passwd);
    	    System.out.println("Connecté à la bdd");

        	
			} catch (SQLException e) {
	    	    e.printStackTrace();
//	    	    LOGGER.log("context", e);
	    	    System.out.println("Erreur");
	    	    System.exit(0);
			}
			return conn;
    }
}
