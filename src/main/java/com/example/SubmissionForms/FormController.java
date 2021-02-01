package com.example.SubmissionForms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	/*
	@PostMapping("/details")
	public String viewDetails(@RequestParam("cid") String cid, 
							@RequestParam("cname") String cname,
							@RequestParam("cemail") String cemail,
							ModelMap modelMap) 
	{
		modelMap.put("cid", cid);
		modelMap.put("cname", cname);
		modelMap.put("cemail", cemail);
		return "viewCustomers";
	}
	*/

}
