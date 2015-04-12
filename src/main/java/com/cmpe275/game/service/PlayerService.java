package com.cmpe275.game.service;

import com.cmpe275.game.model.Player;

public interface PlayerService {
	public void add(Player player);
	public void edit(Player player);
	public void delete(int id);
	public Player getPlayer(int id);
}
