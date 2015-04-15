package com.cmpe275.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe275.game.dao.OpponentDao;
import com.cmpe275.game.model.Opponent;
import com.cmpe275.game.service.OpponentService;

@Service
public class OpponentServiceImpl implements OpponentService {

	@Autowired 
	OpponentDao opponentDao;
	
	@Transactional
	public void add(Opponent opponent) {
		opponentDao.add(opponent);
	}

	@Transactional
	public void delete(Opponent opponent) {
		opponentDao.delete(opponent);
	}

	@Transactional
	public Opponent search(Integer id1, Integer id2) {
		return opponentDao.search(id1, id2);
	}

	@Transactional
	public List<Integer> getAllOpponents(int playerId) {
		return opponentDao.getAllOpponents(playerId);
	}

}
