package com.rk.service;

import com.rk.entity.IPLPlayer;

public interface IPlayerMgmtService {
	public String savePlayer(IPLPlayer player);
	public Iterable<IPLPlayer> showAllPlayers();
	public IPLPlayer showPlayerById(Integer id);
}
