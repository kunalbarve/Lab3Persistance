package com.cmpe275.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe275.game.dao.AddressDao;
import com.cmpe275.game.model.Address;
import com.cmpe275.game.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressDao addressDao;
	
	@Transactional
	public void add(Address address) {
		addressDao.add(address);
	}

	@Transactional
	public void edit(Address address) {
		addressDao.edit(address);
	}
}
