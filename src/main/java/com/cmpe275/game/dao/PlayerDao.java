package com.cmpe275.game.dao;

import java.util.List;

import com.cmpe275.game.model.Player;

public interface PlayerDao {
	public void add(Player player);
	public void edit(Player player);
	public void delete(int id);
	public Player getPlayer(int id);
	public List<Player> getAllPlayer();
}
