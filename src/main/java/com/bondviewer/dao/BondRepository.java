package com.bondviewer.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bondviewer.entity.Bond;

import java.util.List;


public interface BondRepository extends JpaRepository<Bond,Integer> {

	public List<Bond> findAll();
}




