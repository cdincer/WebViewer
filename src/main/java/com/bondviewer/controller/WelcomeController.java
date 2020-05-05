package com.bondviewer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bondviewer.entity.Bond;
import com.bondviewer.service.BondService;


@Controller
class WelcomeController {

	@Autowired
	private BondService MBondService;	
	
	public WelcomeController(BondService InBondService)
	{	
		MBondService =InBondService;	
	}
	
	
	@GetMapping("/")
	public String welcome(Model theModel) {
		
	List<Bond> employeeList = MBondService.findAll();
		
		// add to the spring model
		theModel.addAttribute("Bonds", employeeList);
		

		return "welcome";
	}

}
