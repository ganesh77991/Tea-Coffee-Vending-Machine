package com.vending.machine.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.vending.machine.model.Containers;
import com.vending.machine.model.Drink;

@Repository
public class MachineDao {

	static Integer teacout = 0;
	static Integer blackTea = 0;
	static Integer coffee = 0;
	static Integer blackCoffee = 0;

	public void getTea(Integer noOfCups) {
		
		System.out.println("oredrs tea"+noOfCups);

		teacout = teacout+noOfCups;
		System.out.println("count "+teacout);
	}

	
	public void getBlackTea(Integer noOfCups) {

		blackTea = blackTea+noOfCups;
	}
	public void getCoffee(Integer noOfCups) {

		coffee =coffee+noOfCups;
	}
	public void getBlackCoffee(Integer noOfCups) {

		blackCoffee =blackCoffee +noOfCups;
	}

	public List<Drink> getDrinks() {

		List<Drink> drinks = new ArrayList<Drink>();

		drinks.add(new Drink("Tea", teacout, teacout*10));
		drinks.add(new Drink("Black Tea", blackTea, blackTea*5));
		drinks.add(new Drink("Coffee", coffee,coffee*15));
		drinks.add(new Drink("Black Coffee", blackCoffee, blackCoffee*10));

		return drinks;

	}
	
	public List<Containers> getContainers(){
		
		List<Containers> conts=new ArrayList<Containers>();
		
		conts.add(new Containers(1, "Tea", 2,1.98f));
		conts.add(new Containers(2, "Coffee", 2, 2.04f));
		conts.add(new Containers(3, "Suger", 8, 7.74f));
		conts.add(new Containers(4, "Water", 15, 14.44f));
		conts.add(new Containers(5, "Milk", 10, 10.22f));
		
		return conts;
	}

}
