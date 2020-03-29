package com.vending.machine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vending.machine.dao.MachineDao;
import com.vending.machine.model.Containers;
import com.vending.machine.model.Drink;
import com.vending.machine.service.MachineService;

@Controller
public class MachineController {

	@Autowired
	private MachineService service;
	
	@Autowired
	private MachineDao dao;

	@RequestMapping("/home")
	// @ResponseBody
	public String test(ModelMap map) {

		map.addAttribute("tea", new Drink("Tea", 1, 10));
		map.addAttribute("blackTea", new Drink("Black Tea", 1, 5));
		map.addAttribute("coffee", new Drink("Coffee", 1, 15));
		map.addAttribute("blackCoffee", new Drink("Black Coffee", 1, 10));
		
		//map.addAttribute("msg", "please oreder some drink");

		return "home";
	}

	@RequestMapping(value = "/getTea", method = RequestMethod.POST)
	public String getTea(@ModelAttribute("tea") Drink tea, ModelMap map) {
		
		dao.getTea(tea.getNoOfCups());

		map.addAttribute("tea", new Drink("Tea", 1, 10));
		map.addAttribute("blackTea", new Drink("Black Tea", 1, 5));
		map.addAttribute("coffee", new Drink("Coffee", 1, 15));
		map.addAttribute("blackCoffee", new Drink("Black Coffee", 1, 10));
		
		map.addAttribute("msg", "Thank you for ordering ' "+tea.getNoOfCups()+" ' Tea");

		return "home";
	}

	@RequestMapping(value = "/getBlackTea", method = RequestMethod.POST)
	public String getBlackTea(@ModelAttribute("blackTea") Drink blackTea, ModelMap map) {
		
		dao.getBlackTea(blackTea.getNoOfCups());

		map.addAttribute("tea", new Drink("Tea", 1, 10));
		map.addAttribute("blackTea", new Drink("Black Tea", 1, 5));
		map.addAttribute("coffee", new Drink("Coffee", 1, 15));
		map.addAttribute("blackCoffee", new Drink("Black Coffee", 1, 10));
		
		map.addAttribute("msg", "Thank you for ordering ' "+blackTea.getNoOfCups()+" ' Black Tea");

		return "home";
	}

	@RequestMapping(value = "/getCoffee", method = RequestMethod.POST)
	public String getCoffee(@ModelAttribute("coffee") Drink coffee, ModelMap map) {
		
		dao.getCoffee(coffee.getNoOfCups());
		
		map.addAttribute("tea", new Drink("Tea", 1, 10));
		map.addAttribute("blackTea", new Drink("Black Tea", 1, 5));
		map.addAttribute("coffee", new Drink("Coffee", 1, 15));
		map.addAttribute("blackCoffee", new Drink("Black Coffee", 1, 10));
		
		map.addAttribute("msg", "Thank you for ordering ' "+coffee.getNoOfCups()+" ' Coffee");

		return "home";
	}

	@RequestMapping(value = "/getBlackCoffee", method = RequestMethod.POST)
	public String getBlackCoffee(@ModelAttribute("blackCoffee") Drink blackCoffee, ModelMap map) {

		dao.getBlackCoffee(blackCoffee.getNoOfCups());
		map.addAttribute("tea", new Drink("Tea", 1, 10));
		map.addAttribute("blackTea", new Drink("Black Tea", 1, 5));
		map.addAttribute("coffee", new Drink("Coffee", 1, 15));
		map.addAttribute("blackCoffee", new Drink("Black Coffee", 1, 10));
		
		map.addAttribute("msg", "Thank you for ordering ' "+blackCoffee.getNoOfCups() +" ' Black Coffee");

		return "home";
	}

	@RequestMapping("/report")
	public String home(ModelMap map) {

		int totalNoOfCups = 0;
		float totalCost = 0;

		List<Drink> drinks = service.getDrinks();

		map.addAttribute("drinks", drinks);

		for (Drink d : drinks) {
			totalCost = totalCost + d.getCost();
			totalNoOfCups = totalNoOfCups + d.getNoOfCups();
		}
		map.addAttribute("noOfCups", totalNoOfCups);
		map.addAttribute("totalCost", totalCost);

		return "salesReport";
	}

	@RequestMapping("/containerstatus")
	public String showContainer(ModelMap map) {

		List<Containers> containers=dao.getContainers();
		
		map.addAttribute("conts", containers);
		
		
		return "containerStatus";
	}
	
	@RequestMapping("/refill")
	public String refill() {
		
		return "refill";
	}

}
