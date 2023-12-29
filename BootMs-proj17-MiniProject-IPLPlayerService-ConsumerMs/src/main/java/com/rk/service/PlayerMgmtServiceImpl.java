package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.IPLPlayer;
import com.rk.entity.IPLTeam;
import com.rk.repository.IIPLPlayerRepository;
import com.rk.repository.IIPLTeamRepository;

import lombok.extern.slf4j.Slf4j;

@Service("teamService")
@Slf4j
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {
	
	@Autowired
	private IIPLPlayerRepository PlayerRepo;
	
	public String savePlayer(IPLPlayer player) {
		log.info("PlayerMgmtServiceImpl.savePlayer()-method");
		int idVal=PlayerRepo.save(player).getPlayerId();
		return "Player is Saved with IdValue::"+idVal;
	}

	@Override
	public Iterable<IPLPlayer> showAllPlayers() {
		log.info("PlayerMgmtServiceImpl.showAllPlayers()-method");
		return PlayerRepo.findAll();
	}

	@Override
	public IPLPlayer showPlayerById(Integer id) {
		log.info("PlayerMgmtServiceImpl.savePlayerById()-method");
		return PlayerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Player ID"));
	}

}
