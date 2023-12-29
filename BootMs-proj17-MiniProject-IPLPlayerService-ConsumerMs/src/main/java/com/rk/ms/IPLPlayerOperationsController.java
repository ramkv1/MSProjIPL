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

import com.rk.client.ITeamServiceCosumerClient;
import com.rk.entity.IPLPlayer;
import com.rk.entity.IPLTeam;
import com.rk.service.IPlayerMgmtService;

@RestController
@RequestMapping("/player/api")
public class IPLPlayerOperationsController {
	
	@Autowired
	private IPlayerMgmtService playerService;
	
	@Autowired
	private ITeamServiceCosumerClient client;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
	//get Team Details from producer MS using FeignClinet comp
	IPLTeam team=client.getTeamById(player.getTeamInfo().getTeamId()).getBody();
	//set Team Object to current Player Object
	player.setTeamInfo(team);
	//use Service
	String msg=playerService.savePlayer(player);
	return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/all")
	public ResponseEntity<Iterable<IPLPlayer>> fetchAllPlayers(){
		//use service
		Iterable<IPLPlayer> list=playerService.showAllPlayers();
		return new ResponseEntity<Iterable<IPLPlayer>>(list,HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<IPLPlayer> findPlayerById(@PathVariable Integer id){
		//use service
		IPLPlayer player=playerService.showPlayerById(id);
		return new ResponseEntity<IPLPlayer>(player,HttpStatus.OK);
	}
}
