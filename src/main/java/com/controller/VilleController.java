package com.controller;


import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	@RequestMapping(value = "/ville/get", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codeCommune") String param) {

		System.out.println("Appel Get");

		return villeBLOService.getInfoVille(param);

	}

	@RequestMapping(value = "/ville/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String appelDelete(@RequestParam(required = false, value = "codePostal") String codePostal) {

		System.out.println("Appel Delete");
		villeBLOService.deleteInfoVille(codePostal);

		return "Delete completed";

	}

	@RequestMapping(value = "/ville/post", method = RequestMethod.POST)
	@ResponseBody
	public String appelPost(@RequestBody() Ville ville) throws ClassNotFoundException, SQLException {

		System.out.println("Appel Post");
		villeBLOService.postInfoVille(ville);

		return "Post completed";

	}

	@RequestMapping(value = "/ville/put", method = RequestMethod.PUT)
	@ResponseBody
	public String appelPut(@RequestBody() Ville ville) throws ClassNotFoundException, SQLException {

		System.out.println("Appel Put");
		villeBLOService.putInfoVille(ville);

		return "Update completed";

	}

}
