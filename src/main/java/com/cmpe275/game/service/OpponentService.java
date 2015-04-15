package com.cmpe275.game.service;

import java.util.List;

import com.cmpe275.game.model.Opponent;

public interface OpponentService {
	public void add(Opponent opponent);
	public void delete(Opponent opponent);
	public Opponent search(Integer id1, Integer id2);
	public List<Integer> getAllOpponents(int id);
}
