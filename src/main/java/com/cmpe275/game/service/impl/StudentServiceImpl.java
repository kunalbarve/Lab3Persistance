package com.cmpe275.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe275.game.dao.AddressDao;
import com.cmpe275.game.dao.StudentDao;
import com.cmpe275.game.model.Address;
import com.cmpe275.game.model.Student;
import com.cmpe275.game.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private AddressDao addessDao;
	
	@Transactional
	public void add(Student student) {
		studentDao.add(student);
		Address address=new Address();
		address.setCity("vadodara");
//		address.setId(667);
		address.setZipcode("street");
		address.setZipcode("123456");
		address.setCountry("country");
		address.setStreet("street");
		addessDao.add(address);
	}

	@Transactional
	public void edit(Student student) {
		studentDao.edit(student);
	}

	@Transactional
	public void delete(int studentId) {
		studentDao.delete(studentId);
	}

	@Transactional
	public Student getStudent(int studentId) {
		return studentDao.getStudent(studentId);
	}

	@Transactional
	public List getAllStudent() {
		return studentDao.getAllStudent();
	}

}
