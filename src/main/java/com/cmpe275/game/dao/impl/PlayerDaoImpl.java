package com.cmpe275.game.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cmpe275.game.dao.PlayerDao;
import com.cmpe275.game.model.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Player player){
		session.getCurrentSession().save(player);
	}

	@Override
	public void edit(Player player) {
		session.getCurrentSession().update(player);
	}

	@Override
	public void delete(int id) {
		session.getCurrentSession().delete((Player)getPlayer(id));;
	}
	
	@Override
	public Player getPlayer(int id) {
		return (Player)session.getCurrentSession().get(Player.class,id);
	}

	@Override
	public List<Player> getAllPlayer() {
		return null;
	}
}
