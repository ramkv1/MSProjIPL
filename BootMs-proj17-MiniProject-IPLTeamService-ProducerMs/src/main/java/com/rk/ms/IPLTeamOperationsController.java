package com.rk.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.entity.IPLTeam;
import com.rk.service.ITeamMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team/api")
@Slf4j
public class IPLTeamOperationsController {
	@Autowired
	private ITeamMgmtService teamService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team){
		log.info("IPLTeamOperationsController.registerTeam()-Method");
		//use service
		String msg=teamService.saveTeam(team);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLTeam>> fetchAllTeams(){
		log.info("IPLTeamOperationsController.fetchAllTeams()-Method");
		//user service
		Iterable<IPLTeam> list=teamService.showAllTeams();
		return new ResponseEntity<Iterable<IPLTeam>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLTeam> findTeamById(@PathVariable Integer id){
		log.info("IPLTeamOperationsController.findTeamById()-Method");
		//use service
		IPLTeam team=teamService.showTeamById(id);
		return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
	}
}
