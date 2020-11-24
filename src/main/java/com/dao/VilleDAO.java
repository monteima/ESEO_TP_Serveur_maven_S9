package com.dao;
import java.util.ArrayList;
import com.dto.Ville;

public interface VilleDAO {

	public ArrayList<Ville> findAllVilles();
	public ArrayList<Ville> findVilleByValue(String codePostal);
//	public ArrayList<Ville> findVilleByValue2(String column, String value);

	public void deleteInfoVille(String codePostal);
	
	public void postInfoVille(Ville ville);
	
//	public void putInfoVille(String codePOstal, Ville ville);


}
