package com.cmpe275.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe275.game.dao.AddressDao;
import com.cmpe275.game.dao.PlayerDao;
import com.cmpe275.game.dao.StudentDao;
import com.cmpe275.game.model.Player;
import com.cmpe275.game.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private AddressDao addessDao;
	@Autowired
	private PlayerDao playerDao;
	
	
	@Transactional
	public void add(Player player) {
		playerDao.add(player);
	}

	
	@Transactional
	public Player getPlayer(int id) {
		return (Player)playerDao.getPlayer(id);
	}

	

	@Transactional
	public void edit(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public List<Player> getAllPlayer() {
		return null;
	}

	@Transactional
	public void delete(int id) {
	}

}
