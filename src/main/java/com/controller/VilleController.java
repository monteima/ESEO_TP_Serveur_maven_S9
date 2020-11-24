package com.controller;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.config.JDBCConfiguration;
import com.dto.Ville;
import com.google.gson.Gson;
import com.mysql.jdbc.PreparedStatement;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeBLOService;
	
	@RequestMapping(value = "/getVille", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String param) {

		System.out.println("Appel Get");
		System.out.println(param);
		
	    ArrayList<Ville> listVille = villeBLOService.getInfoVille(param);
	    
	    return listVille;

	}
	
	@RequestMapping(value = "/deleteVille", method = RequestMethod.DELETE)
	@ResponseBody
	public String appelDelete(@RequestParam(required = false, value = "codePostal") String codePostal) {

		System.out.println("Appel Delete");
		
		System.out.println(codePostal);
		
	    villeBLOService.deleteInfoVille(codePostal);
	    
	    return "Delete completed";

	}
	
	@RequestMapping(value = "/postVille", method = RequestMethod.POST)
	@ResponseBody
	public String appelPost() {

		System.out.println("Appel Post");
				
	    villeBLOService.postInfoVille();
	    
	    return "Post completed";

	}
	
//	@RequestMapping(value = "/putVille", method = RequestMethod.PUT)
//	@ResponseBody
//	public String appelPut() {
//
//		System.out.println("Appel Put");
//				
//	    villeBLOService.putInfoVille();
//	    
//	    return "Update completed";
//
//	}

}
