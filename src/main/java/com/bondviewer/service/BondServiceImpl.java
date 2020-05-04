package com.bondviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bondviewer.dao.BondRepository;
import com.bondviewer.entity.Bond;

@Service
public class BondServiceImpl implements BondService{

	private BondRepository myBondRepository;
	//Qualifier added in there to show what happens when you have 2 beans that have the same blueprint 
	//Specify which one to use
	@Autowired
	public BondServiceImpl (BondRepository theBondRepository)
	{
		myBondRepository = theBondRepository;
	}
	
	
	
	@Override
	public List<Bond> findAll() {
		return myBondRepository.findAll();
	}

	@Override
	public Bond findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Bond theEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
