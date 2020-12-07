package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;


public class JDBCConfiguration {
	
		public static Connection getConnection() throws ClassNotFoundException{		

			Connection conn = null;
			Logger logger = Logger.getLogger("logger");

			
			String bdd = "ville_de_france";
	    	String url = "jdbc:mysql://localhost:3306/" + bdd;
	    	String user = "root";
	    	String passwd = "";
			
			
        try {
        	
    	    Class.forName("com.mysql.jdbc.Driver");
    	    conn = DriverManager.getConnection(url, user, passwd);
    		logger.log(Level.INFO, "Connecté à la bdd");


        	
			} catch (SQLException e) {
	    	    logger.log(Level.INFO, "context", e);
	    		logger.log(Level.INFO, "Erreur");
	    	    System.exit(0);
			}
			return conn;
    }
}
