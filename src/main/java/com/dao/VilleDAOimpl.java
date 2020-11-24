package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOimpl implements VilleDAO {
	
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		try {
    		Connection conn = JDBCConfiguration.getConnection();
    		
        	java.sql.Statement st = null;
    	    st = conn.createStatement();

    	    ResultSet rs = null;
    	    
    	    String sql1 = "SELECT * FROM `ville_france`";
    	    rs = st.executeQuery(sql1);
    	    
    	    while (rs.next()) {
    	    	Ville ville = new Ville();
    	    	
    	    	ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
    	    	ville.setNomCommune(rs.getString("Nom_commune"));
    	    	ville.setCodePostale(rs.getString("Code_postal"));
    	    	ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
    	    	ville.setLigne(rs.getString("Ligne_5"));
    	    	ville.setLatitude(rs.getString("Latitude"));
    	    	ville.setLongitude(rs.getString("Longitude"));
    	    	
    	    	listVille.add(ville);
    	    	
			}

		} catch (Exception e){
    	    e.printStackTrace();
    	    System.out.println("Erreur");
    	    System.exit(0);
    	}
		
		return listVille;
	}
	
	public ArrayList<Ville> findVilleByValue(String codePostal) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		try {
    		Connection conn = JDBCConfiguration.getConnection();
    		
        	java.sql.Statement st = null;
    	    st = conn.createStatement();

    	    ResultSet rs = null;
    	    
    	    String sql1 = "SELECT * FROM `ville_france` WHERE `Code_postal`=" + codePostal +"";

    	    rs = st.executeQuery(sql1);
    	    
    	    while (rs.next()) {
    	    	Ville ville = new Ville();
    	    	
    	    	ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
    	    	ville.setNomCommune(rs.getString("Nom_commune"));
    	    	ville.setCodePostale(rs.getString("Code_postal"));
    	    	ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
    	    	ville.setLigne(rs.getString("Ligne_5"));
    	    	ville.setLatitude(rs.getString("Latitude"));
    	    	ville.setLongitude(rs.getString("Longitude"));
    	    	
    	    	listVille.add(ville);
    	    	
			}

		} catch (Exception e){
    	    e.printStackTrace();
    	    System.out.println("Erreur");
    	    System.exit(0);
    	}
		
		return listVille;
	}
	
//	public ArrayList<Ville> findVilleByValue2(String column, String value) {
//		ArrayList<Ville> listVille = new ArrayList<Ville>();
//		
//		try {
//    		Connection conn = JDBCConfiguration.getConnection();
//    		
//        	java.sql.Statement st = null;
//    	    st = conn.createStatement();
//
//    	    ResultSet rs = null;
//    	    
//    	    String sql1 = "SELECT * FROM `ville_france` WHERE `"+ column +"`=" + value +"";
//
//    	    rs = st.executeQuery(sql1);
//    	    
//    	    while (rs.next()) {
//    	    	Ville ville = new Ville();
//    	    	
//    	    	ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
//    	    	ville.setNomCommune(rs.getString("Nom_commune"));
//    	    	ville.setCodePostale(rs.getString("Code_postal"));
//    	    	ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
//    	    	ville.setLigne(rs.getString("Ligne_5"));
//    	    	ville.setLatitude(rs.getString("Latitude"));
//    	    	ville.setLongitude(rs.getString("Longitude"));
//    	    	
//    	    	listVille.add(ville);
//    	    	
//			}
//
//		} catch (Exception e){
//    	    e.printStackTrace();
//    	    System.out.println("Erreur");
//    	    System.exit(0);
//    	}
//		
//		return listVille;
//	}
	
	public void deleteInfoVille(String codePostal) {
		
		try {
    		Connection conn = JDBCConfiguration.getConnection();
    		
//        	java.sql.Statement st = null;
//
//    	    ResultSet rs = null;
    	    
    	    String sql1 = "DELETE FROM `ville_france` WHERE `Code_postal`="+ codePostal +"";
    	    
    	    Statement statement = conn.createStatement();
    	    statement.executeUpdate(sql1);
    	    

		} catch (Exception e){
    	    e.printStackTrace();
    	    System.out.println("Erreur");
    	    System.exit(0);
    	}
	}

	public void postInfoVille(Ville ville) {

		try {
    		Connection conn = JDBCConfiguration.getConnection();
    		    	    
	   	    String sql1 = "INSERT INTO `ville_france` (`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) "
    	    		+ "VALUES ('" + ville.getCodeCommune() + "', '"+ ville.getNomCommune() +"', '"+ ville.getCodePostale() +"', '"+ ville.getLibelleAcheminement() +"', '"+ ville.getLigne() +"', '"+ ville.getLatitude() +"', '"+ ville.getLongitude() +"');";    	    
    	    Statement statement = conn.createStatement();
    	    statement.executeUpdate(sql1);
    	    

		} catch (Exception e){
    	    e.printStackTrace();
    	    System.out.println("Erreur");
    	    System.exit(0);
    	}
	
	}

//	public void putInfoVille(String codePOstal, Ville ville) {
//		// TODO Auto-generated method stub
//		
//	}

}
