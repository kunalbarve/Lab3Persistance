package com.cmpe275.game.dao.impl;

import java.awt.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmpe275.game.dao.AddressDao;
import com.cmpe275.game.dao.PlayerDao;
import com.cmpe275.game.model.Address;
import com.cmpe275.game.model.Player;
import com.cmpe275.game.model.Student;


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
		// TODO Auto-generated method stub
		session.getCurrentSession().update(player);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete((Player)getPlayer(id));;
		
	}
	
	@Override
	public Player getPlayer(int id) {
		// TODO Auto-generated method stub
		return (Player)session.getCurrentSession().get(Player.class,id);
	}

	@Override
	public List getAllPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

}
