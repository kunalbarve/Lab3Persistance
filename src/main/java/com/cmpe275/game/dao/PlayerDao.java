package com.cmpe275.game.dao;

import java.awt.List;

import com.cmpe275.game.model.*;

	
	public interface PlayerDao {
		public void add(Player player);
		public void edit(Player player);
		public void delete(int id);
		public Player getPlayer(int id);
		public List getAllPlayer();
	}
