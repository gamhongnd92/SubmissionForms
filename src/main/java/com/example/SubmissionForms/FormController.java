package com.example.SubmissionForms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@Autowired
	CustomerRepo repo;
	@RequestMapping("/")
	public String details() {
		return "gam";
	}
	
	@RequestMapping("/details")
	public String details(Customers customers) {
		repo.save(customers);
		return "gam";
	}
	
	@RequestMapping("/getDetails")
	public String getDetails() {
		return "viewCustomers";
	}
	
	
	
	@PostMapping("/getDetails")
	public ModelAndView getDetails(@RequestParam int cid) 
	{
		ModelAndView mv = new ModelAndView("Retrieve");
		Customers customers = repo.findById(cid).orElse(null);
		mv.addObject(customers);
		return mv;
	}
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customers> getCustomer() {
		return repo.findAll();
	}
	
	@RequestMapping("/customers/{cid}")
	@ResponseBody
	public Optional<Customers> getCustomer2(@PathVariable("cid") int cid) {
		return repo.findById(cid);
	}
	
	@PostMapping("/customers")
	@ResponseBody
	public Customers getCustomer3(@RequestBody Customers customers) {
		repo.save(customers);
		return customers;
	}
	
	@DeleteMapping("/customers/{cid}")
	public Customers getCustomer4(@PathVariable("cid") int cid) {
		Customers cust = repo.getOne(cid);
		repo.delete(cust);
		return cust;
	}

	@PutMapping(path ="/customers", consumes= {"application/json"})
	public Customers getCustomer5(@RequestBody Customers customers) {
		
		repo.save(customers);
		return customers;
	}


}
