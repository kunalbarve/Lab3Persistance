package com.cmpe275.game.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmpe275.game.dao.SponsorDao;
import com.cmpe275.game.model.Sponsor;

@Repository
public class SponsorDaoImpl implements SponsorDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Sponsor sponsor) {
		session.getCurrentSession().save(sponsor);
	}

	@Override
	public void edit(Sponsor sponsor) {
		session.getCurrentSession().update(sponsor);
	}

	@Override
	public void delete(int id) {
	Query query = session.getCurrentSession().createQuery("delete Sponsor where sponsorId = :ID");
		query.setParameter("ID", id);
		query.executeUpdate();
	}

	@Override
	public Sponsor getSponsor(int id) {
		return (Sponsor)session.getCurrentSession().get(Sponsor.class, id);
	}
}
