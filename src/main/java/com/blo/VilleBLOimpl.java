package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOimpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	public ArrayList<Ville> getInfoVille(String codeCommune) {
		ArrayList<Ville> listeVille;

		if (codeCommune == null || "".equalsIgnoreCase(codeCommune)) {
			listeVille = villeDAO.findAllVilles();
		} else {
			listeVille = villeDAO.findVilleByValue(codeCommune);
		}

		return listeVille;
	}

	public void deleteInfoVille(String codePostal) {

		villeDAO.deleteInfoVille(codePostal);

	}

	public void postInfoVille(Ville ville) {

		villeDAO.postInfoVille(ville);

	}

	public void putInfoVille(Ville ville) {

		villeDAO.putInfoVille(ville);

	}

}
