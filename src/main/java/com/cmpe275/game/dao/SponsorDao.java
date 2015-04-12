package com.cmpe275.game.dao;

import java.util.List;

import com.cmpe275.game.model.Sponsor;

public interface SponsorDao {
	public void add(Sponsor sponsor);
	public void edit(Sponsor sponsor);
	public void delete(int id);
	public Sponsor getSponsor(int id);
	public List<Sponsor> getAllSponsors();
}
