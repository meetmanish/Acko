package com.example.springboot;


import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRep {
	
	@Autowired
	DbConnection db;
	
	public void createTeamDev(RequestBody request) throws SQLException{
		String id = UUID.randomUUID().toString();
		
		Team team = request.getTeam();
		team.setId(id);
		List<Developer> dev = request.getDev();
		for(Developer d : dev){
			d.setTeam_id(id);
			db.createDev(d);
		}
		db.createTeam(team);
		
	}

}
