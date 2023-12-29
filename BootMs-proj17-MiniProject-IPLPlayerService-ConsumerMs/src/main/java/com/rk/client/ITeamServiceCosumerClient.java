package com.rk.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rk.entity.IPLTeam;

@FeignClient("TEAM-SERVICE")
public interface ITeamServiceCosumerClient {
	
	@GetMapping("/team/api/find/{id}")
	public ResponseEntity<IPLTeam> getTeamById(@PathVariable Integer id);
}
