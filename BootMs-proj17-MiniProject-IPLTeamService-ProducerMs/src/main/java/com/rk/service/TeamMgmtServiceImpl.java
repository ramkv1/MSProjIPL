package com.rk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.IPLTeam;
import com.rk.repository.IIPLTeamRepository;

import lombok.extern.slf4j.Slf4j;

@Service("teamService")
@Slf4j
public class TeamMgmtServiceImpl implements ITeamMgmtService {

	@Autowired
	private IIPLTeamRepository teamRepo;
	
	
	
	@Override
	public String saveTeam(IPLTeam team) {
		log.info("TeamMgmtServiceImpl.saveTeam()");
		return "Team and Player are Saved with id value::"+teamRepo.save(team).getTeamId();
	}



	@Override
	public Iterable<IPLTeam> showAllTeams() {
		log.info("TeamMgmtServiceImpl.showAllTeams()");
		return teamRepo.findAll();
	}



	@Override
	public IPLTeam showTeamById(Integer id) {
		log.info("TeamMgmtServiceImpl.showTeamById");
		return teamRepo.getOne(id);
	}

}
