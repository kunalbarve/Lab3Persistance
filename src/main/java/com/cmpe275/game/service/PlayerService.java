package com.cmpe275.game.service;

import java.util.List;

import com.cmpe275.game.model.Player;
import com.cmpe275.game.model.Sponsor;

public interface PlayerService {
	public void add(Player player);
	public void edit(Player player);
	public void delete(int id);
	public Player getPlayer(int id);
	public List<Player> getPlyerList(Sponsor sponsor);
}
