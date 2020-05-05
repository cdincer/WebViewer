package com.bondviewer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bondviewer.dao.BondRepository;
import com.bondviewer.entity.Bond;

@Service
public class BondServiceImpl implements BondService {

	private BondRepository myBondRepository;

	// Qualifier added in there to show what happens when you have 2 beans that have
	// the same blueprint
	// Specify which one to use
	@Autowired
	public BondServiceImpl(BondRepository theBondRepository) {
		myBondRepository = theBondRepository;
	}

	@Override
	public List<Bond> findMinMax() {
		List<Bond> Items = myBondRepository.findAll();
		List<Bond> Filtered = new ArrayList<Bond>();
		HashMap<Integer, Bond> Returned = new HashMap<Integer, Bond>();
		Bond Comparison = new Bond();
		double low, high;
		Integer tempbondNo;
		low = high = 0;

		// max
		for (Bond Item : Items) {
			low = Item.getBankSell();
			tempbondNo = Item.getBondNumber();

			if (!Returned.containsKey(tempbondNo))
				Returned.put(tempbondNo, Item);
			else {
				Comparison = Returned.get(tempbondNo);
				if (low > Comparison.getBankSell()) {
				 Returned.remove(Comparison.getBondNumber(), Comparison);
				 Returned.put(Item.getBondNumber(),Item);
				}

			}

		}
		
		 Items = new ArrayList<Bond>();
		   for(Map.Entry<Integer,Bond> item : Returned.entrySet())
		   {
			   Items.add(item.getValue());
		   }

		return Items;
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
