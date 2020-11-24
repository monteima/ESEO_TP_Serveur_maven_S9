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

	public ArrayList<Ville> getInfoVille(String codePostal) {
		ArrayList<Ville> listeVille;
		
		if (codePostal == null || "".equalsIgnoreCase(codePostal)) {
			listeVille = villeDAO.findAllVilles();
		} else {
			listeVille = villeDAO.findVilleByValue(codePostal);
		}
		
		return listeVille;
	}
		
	
	public void deleteInfoVille(String codePostal) {
		
		villeDAO.deleteInfoVille(codePostal);
		
	}
	
	public void postInfoVille() {
		
		Ville ville = new Ville();
    	
    	ville.setCodeCommune("98000");
    	ville.setNomCommune("Boulogne-Billancourt");
    	ville.setCodePostale("92100");
    	ville.setLibelleAcheminement("");
    	ville.setLigne("Ligne_5");
    	ville.setLatitude("675765");
    	ville.setLongitude("867766");
		
		villeDAO.postInfoVille(ville);

	}


	public void putInfoVille(String codePostal) {
		
		Ville ville = new Ville();
    	
    	ville.setCodeCommune("98500");
//    	ville.setNomCommune("Boulogne-Billancourt");
//    	ville.setCodePostale("92100");
//    	ville.setLibelleAcheminement("");
//    	ville.setLigne("Ligne_5");
//    	ville.setLatitude("675765");
//    	ville.setLongitude("867766");
		
		
//		villeDAO.putInfoVille(codePostal, ville);
		
	}


	
}
