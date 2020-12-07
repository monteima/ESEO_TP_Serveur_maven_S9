package com.blo;

import java.util.ArrayList;
import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVille(String codeCommune);

	public void deleteInfoVille(String codePostal);

	public void postInfoVille(Ville ville);

	public void putInfoVille(Ville ville);

}
