package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	
	@Autowired
	ServiceRep service;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@POST
	@Path("/create")
	public Response createTeam(@RequestBody RequestBody request){
		
		request.getTeam();
		service.createTeamDev(request);
		Response res = new Response();
		res.setRes("");
		
		return res;
		
	}

}
