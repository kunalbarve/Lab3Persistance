package com.cmpe275.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe275.game.dao.PlayerDao;
import com.cmpe275.game.model.Player;
import com.cmpe275.game.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerDao playerDao;
	
	@Transactional
	public void add(Player player) {
		playerDao.add(player);
	}

	@Transactional
	public Player getPlayer(int id) {
		return playerDao.getPlayer(id);
	}

	@Transactional
	public void edit(Player player) {
		playerDao.edit(player);
	}

	@Transactional
	public void delete(int id) {
		playerDao.delete(id);
	}
}
