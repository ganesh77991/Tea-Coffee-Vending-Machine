package com.vending.machine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.machine.dao.MachineDao;
import com.vending.machine.model.Drink;
import com.vending.machine.model.Refill;

@Service
public class MachineService {
	
	@Autowired
	private MachineDao dao;
	
	

	public List<Drink> getDrinks() {
		// TODO Auto-generated method stub
		return dao.getDrinks();
	}

}
