package com.cmpe275.game.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmpe275.game.dao.PlayerDao;
import com.cmpe275.game.model.Player;
import com.cmpe275.game.model.Sponsor;

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
		
		Query query = session.getCurrentSession().createQuery("delete Player where id = :ID");
		
		query.setParameter("ID", id);
		 
		query.executeUpdate();
	}
	
	@Override
	public Player getPlayer(int id) {
		return (Player)session.getCurrentSession().get(Player.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Player> getPlayerList(Sponsor sponsor) {
		//List<Player> list = (List<Player>)session.getCurrentSession().createQuery("from player as p where p.sponsorId = ?")
		Criteria c=session.getCurrentSession().createCriteria(Player.class, "p");
		c.add(Restrictions.eq("p.sponsor.id", sponsor.getId()));
		List<Player> lstPlayer=(ArrayList<Player>)c.list();
		return lstPlayer;
	}
	
}
