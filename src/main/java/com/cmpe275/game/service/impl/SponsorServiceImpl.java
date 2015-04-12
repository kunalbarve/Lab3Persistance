package com.cmpe275.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe275.game.dao.SponsorDao;
import com.cmpe275.game.model.Sponsor;
import com.cmpe275.game.service.SponsorService;

@Service
public class SponsorServiceImpl implements SponsorService {
	
	@Autowired
	private SponsorDao sponsorDao;
	
	@Transactional
	public void add(Sponsor sponsor) {
		sponsorDao.add(sponsor);
	}

	@Transactional
	public void edit(Sponsor sponsor) {
		sponsorDao.edit(sponsor);
	}

	@Transactional
	public void delete(int id) {
		sponsorDao.delete(id);
	}

	@Transactional
	public Sponsor getSponsor(int id) {
		return sponsorDao.getSponsor(id);
	}
}
