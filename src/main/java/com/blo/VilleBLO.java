package com.blo;

import java.util.ArrayList;
import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVille(String codePostal);
	
	public void deleteInfoVille(String codePostal);
	
	public void postInfoVille();
	
//	public void putInfoVille(String codePostal);


}
