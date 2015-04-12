package com.cmpe275.game.service;

import com.cmpe275.game.model.Sponsor;

public interface SponsorService {
	public void add(Sponsor sponsor);
	public void edit(Sponsor sponsor);
	public void delete(int id);
	public Sponsor getSponsor(int id);
}
