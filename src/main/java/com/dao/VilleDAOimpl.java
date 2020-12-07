package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOimpl implements VilleDAO {

	Logger logger = Logger.getLogger("logger");
	private static final String ERREUR = "erreur";
	private static final String CONTEXT = "context";

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		try {
			Connection conn = JDBCConfiguration.getConnection();

			String sql1 = "SELECT * FROM `ville_france`";

			try (Statement st = conn.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql1)) {

					while (rs.next()) {
						Ville ville = new Ville();

						ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
						ville.setNomCommune(rs.getString("Nom_commune"));
						ville.setCodePostal(rs.getString("Code_postal"));
						ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
						ville.setLigne(rs.getString("Ligne_5"));
						ville.setLatitude(rs.getString("Latitude"));
						ville.setLongitude(rs.getString("Longitude"));

						listVille.add(ville);

					}

				} catch (SQLException e) {

				}

			} catch (SQLException e) {

			}

		} catch (Exception e) {
			logger.log(Level.INFO, CONTEXT, e);
			logger.log(Level.INFO, ERREUR);
			System.exit(0);
		}

		return listVille;
	}

	public ArrayList<Ville> findVilleByValue(String codeCommune) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		try {
			Connection conn = JDBCConfiguration.getConnection();

			String sql1 = "SELECT * FROM `ville_france` WHERE `Code_commune_INSEE`='" + codeCommune + "'";

			try (Statement st = conn.createStatement()) {

				try (ResultSet rs = st.executeQuery(sql1)) {

				while (rs.next()) {
					Ville ville = new Ville();

					ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
					ville.setNomCommune(rs.getString("Nom_commune"));
					ville.setCodePostal(rs.getString("Code_postal"));
					ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
					ville.setLigne(rs.getString("Ligne_5"));
					ville.setLatitude(rs.getString("Latitude"));
					ville.setLongitude(rs.getString("Longitude"));

					listVille.add(ville);

				}
				
				} catch (SQLException e) {

				}

			} catch (SQLException e) {

			}

		} catch (Exception e) {
			logger.log(Level.INFO, CONTEXT, e);
			logger.log(Level.INFO, ERREUR);
			System.exit(0);
		}

		return listVille;
	}

	public void deleteInfoVille(String codePostal) {

		try {
			Connection conn = JDBCConfiguration.getConnection();

			String sql1 = "DELETE FROM `ville_france` WHERE `Code_postal`=" + codePostal + "";

			try (Statement st = conn.createStatement()) {

				st.executeUpdate(sql1);

			} catch (SQLException e) {

			}

		} catch (Exception e) {
			logger.log(Level.INFO, CONTEXT, e);
			logger.log(Level.INFO, ERREUR);
			System.exit(0);
		}
	}

	public void postInfoVille(Ville ville) {

		try {
			Connection conn = JDBCConfiguration.getConnection();

			String sql1 = "INSERT INTO `ville_france` (`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) "
					+ "VALUES ('" + ville.getCodeCommune() + "', '" + ville.getNomCommune() + "', '"
					+ ville.getCodePostal() + "', '" + ville.getLibelleAcheminement() + "', '" + ville.getLigne()
					+ "', '" + ville.getLatitude() + "', '" + ville.getLongitude() + "');";

			try (Statement st = conn.createStatement()) {

				st.executeUpdate(sql1);

			} catch (SQLException e) {

			}

		} catch (Exception e) {
			logger.log(Level.INFO, CONTEXT, e);
			logger.log(Level.INFO, ERREUR);
			System.exit(0);
		}

	}

	public void putInfoVille(Ville ville) {
		try {
			Connection conn = JDBCConfiguration.getConnection();

			String sql1 = "UPDATE `ville_france` SET `Nom_commune`='" + ville.getNomCommune() + "',`Code_postal`='"
					+ ville.getCodePostal() + "',`Libelle_acheminement`='" + ville.getLibelleAcheminement()
					+ "',`Ligne_5`='" + ville.getLigne() + "',`Latitude`='" + ville.getLatitude() + "',`Longitude`='"
					+ ville.getLongitude() + "' WHERE `Code_commune_INSEE`='" + ville.getCodeCommune() + "'";

			try (Statement st = conn.createStatement()) {

				st.executeUpdate(sql1);

			} catch (SQLException e) {

			}

		} catch (Exception e) {
			logger.log(Level.INFO, CONTEXT, e);
			logger.log(Level.INFO, ERREUR);
			System.exit(0);
		}
	}

}
