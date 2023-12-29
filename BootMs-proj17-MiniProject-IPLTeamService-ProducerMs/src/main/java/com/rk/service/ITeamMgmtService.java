package com.rk.service;

import com.rk.entity.IPLTeam;

public interface ITeamMgmtService {
	public String saveTeam(IPLTeam team);
	public Iterable<IPLTeam> showAllTeams();
	public IPLTeam showTeamById(Integer id);
}
