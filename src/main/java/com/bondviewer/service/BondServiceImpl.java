package com.bondviewer.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

		//max
		HashMap<Integer, Bond> Returned = new HashMap<Integer, Bond>();
		//min
		HashMap<Integer, Bond> Returned2 = new HashMap<Integer, Bond>();

		Bond Comparison = new Bond();
		double low, high;
		Integer tempbondNo;
		low = high = 0;

		// max
		for (Bond Item : Items) {
			high = Item.getBankSell();
			tempbondNo = Item.getBondNumber();

			if (!Returned.containsKey(tempbondNo))
				Returned.put(tempbondNo, Item);
			else {
				Comparison = Returned.get(tempbondNo);
				if (high > Comparison.getBankSell()) {
				 Returned.remove(Comparison.getBondNumber(), Comparison);
				 Returned.put(Item.getBondNumber(),Item);
				}

			}

		}
		
		
		//min
		for (Bond Item : Items) {
			low = Item.getBankSell();
			tempbondNo = Item.getBondNumber();

			if (!Returned2.containsKey(tempbondNo))
				Returned2.put(tempbondNo, Item);
			else {
				Comparison = Returned2.get(tempbondNo);
				if (low < Comparison.getBankSell()) {
					Returned2.remove(Comparison.getBondNumber(), Comparison);
					Returned2.put(Item.getBondNumber(),Item);
				}

			}

		}
		
		
		 Items = new ArrayList<Bond>();
		   for(Map.Entry<Integer,Bond> item : Returned.entrySet())
		   {
			   
			   Items.add(item.getValue());
		   }
		   
		   for(Map.Entry<Integer,Bond> item : Returned2.entrySet())
		   {
			   Items.add(item.getValue());
		   }
		   
		   Bond[] BondArray = new Bond[Items.size()];
		   int x=0;
		   for(Bond Item:Items)
		   {
			   BondArray[x]=Item;
			   x++;
		   }
		    boolean sorted = false;
		   Bond temp = new Bond();
		 
		    while (!sorted) {
		        sorted = true;
		        for (int i = 0; i < BondArray.length - 1; i++) {
		            if (BondArray[i].getBondNumber() > BondArray[i+1].getBondNumber()) {
		                temp = BondArray[i];
		                BondArray[i] = BondArray[i+1];
		                BondArray[i+1] = temp;
		                sorted = false;
		            }
		        }
		    }
		   
		   
		   
		   Items.clear();
		   for(int i=0;i<BondArray.length;i++)
		   {
			   Items.add(BondArray[i]);

		   }

		return Items;
	}

	@Override
	public List<Bond> findAll() {
		return myBondRepository.findAll();
	}

	@Override
	public Bond findById(int theId) {
		//Optional means different pattern instead of having to check for nulls 
		//Feature introduced in Java 8
		Optional<Bond> result = myBondRepository.findById(theId);
		
		Bond myBond= null;
		if(result.isPresent())
		{
			myBond = result.get();
		}
		else
		{
			throw new RuntimeException("Did not find employee id -" + theId);
		}
		
		return myBond;
	}

	@Override
	public void save(Bond theBond) {
		myBondRepository.save(theBond);

	}

	@Override
	public void deleteById(int theId) {
		myBondRepository.deleteById(theId);

	}

}
