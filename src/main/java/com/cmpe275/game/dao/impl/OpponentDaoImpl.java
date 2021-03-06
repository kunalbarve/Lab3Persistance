package com.cmpe275.game.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmpe275.game.dao.OpponentDao;
import com.cmpe275.game.model.Opponent;

@Repository
public class OpponentDaoImpl implements OpponentDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Opponent opponent) {
		session.getCurrentSession().save(opponent);
	}

	@Override
	public void delete(Opponent opponent) {
	Query query = session.getCurrentSession().createQuery("delete Opponent where id = :ID");
		query.setParameter("ID", opponent.getId());
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Opponent search(Integer id1, Integer id2) {
		Criteria c=session.getCurrentSession().createCriteria(Opponent.class, "o");
		c.add(Restrictions.eq("o.player1.id", id1));
		c.add(Restrictions.eq("o.player2.id", id2));
		List<Opponent> lstOpponent=c.list();
		if(lstOpponent!=null && lstOpponent.size()>0){
			return lstOpponent.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getAllOpponents(int playerId) {
		Criteria c=session.getCurrentSession().createCriteria(Opponent.class, "o");
		c.add(Restrictions.eq("o.player1.id", playerId));
		List<Opponent> listOpponents = (ArrayList<Opponent>)c.list();
		List<Integer> oppList = new ArrayList<Integer>();
		for(Opponent o : listOpponents){
			oppList.add(o.getPlayer2().getId());
		}
		return oppList;
	}
}
