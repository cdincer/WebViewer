package com.bondviewer.service;

import java.util.List;

import com.bondviewer.entity.Bond;

public interface BondService {
	
	public List<Bond> findAll();
	public Bond findById(int theId);
	public void save(Bond theEmployee);
	public void deleteById(int theId);
	public List<Bond> findMinMax();

}
