package com.cmpe275.game.service;

import com.cmpe275.game.model.Opponent;

public interface OpponentService {
	public void add(Opponent opponent);
	public void delete(Opponent opponent);
	public Opponent search(Integer id1, Integer id2);
}
