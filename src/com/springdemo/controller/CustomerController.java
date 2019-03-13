package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//INJECT CUSTOMER SERVICE
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//GET CUSTOMER
		List<Customer> theCustomers = customerService.getCustomers();
		
		//ADD CUSTOMER TO MODEL
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theMOdel) {
		
		Customer theCustomer = new Customer();
		theMOdel.addAttribute("customer", theCustomer);
			
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//SAVE CUSTOMER USING SERVICE
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theID, Model theModel) {
		
		//GET CUSTOMER FROM SERVICE
		Customer theCustomer = customerService.getCustomer(theID);
		
		//SET CUSTOMER AS MODEL ATTRIBUTE TO PRE-POPULATE THE FORM
		theModel.addAttribute("customer", theCustomer);
				
		return "customer-form";
	}
	
	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("customerId") int theID) {
		
		//DELETE CUSTOMER
		customerService.deleteCustomer(theID);
				
		return "redirect:/customer/list";
	}
	
	
	
}
