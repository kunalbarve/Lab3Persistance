package com.cmpe275.game.dao;

import com.cmpe275.game.model.Opponent;
import com.cmpe275.game.model.Sponsor;

public interface OpponentDao {
	public void add(Opponent opponent);
	public void delete(Opponent opponent);
	public Opponent search(Integer id1, Integer id2);
}
