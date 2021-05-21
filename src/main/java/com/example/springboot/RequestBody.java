package com.example.springboot;

import java.util.List;

public class RequestBody {

	private Team team;
	
	private List<Developer> dev;

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Developer> getDev() {
		return dev;
	}

	public void setDev(List<Developer> dev) {
		this.dev = dev;
	}
	
	
}
