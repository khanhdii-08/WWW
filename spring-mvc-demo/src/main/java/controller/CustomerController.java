package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private static List<Customer> customers;
	public CustomerController() {
		customers = new ArrayList<Customer>();
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute Customer customer, Model model) {
		customer.setId(randomID(customers));
		System.out.println(customer);
		customers.add(customer);
		model.addAttribute("customers", customers);
		return "customer-confirmation";
	}
	
	
	public String randomID(List<Customer> customers) {
		String id = String.valueOf(UUID.randomUUID());
		while(customers.contains(id)) {
			id = String.valueOf(UUID.randomUUID());
		}
		return id;
	}
}
