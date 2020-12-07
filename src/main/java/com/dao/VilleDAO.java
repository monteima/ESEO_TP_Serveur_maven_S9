package com.dao;

import java.util.ArrayList;
import com.dto.Ville;

public interface VilleDAO {

	public ArrayList<Ville> findAllVilles();

	public ArrayList<Ville> findVilleByValue(String codeCommune);

	public void deleteInfoVille(String codePostal);

	public void postInfoVille(Ville ville);

	public void putInfoVille(Ville ville);

}
