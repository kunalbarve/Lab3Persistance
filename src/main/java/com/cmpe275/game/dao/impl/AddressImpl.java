package com.cmpe275.game.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmpe275.game.dao.AddressDao;
import com.cmpe275.game.model.Address;


@Repository
public class AddressImpl implements AddressDao {
	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Address address){
		session.getCurrentSession().save(address);
	}

	@Override
	public void edit(Address address) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(address);
	}

	public Address getAddress(int id) {
		return (Address)session.getCurrentSession().get(Address.class, id);
	}
}
