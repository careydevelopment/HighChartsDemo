package com.careydevelopment.validationdemo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.careydevelopmnet.validationdemo.model.Employee;

@Controller
public class FormController {

	//starting page for form validation demo
	@RequestMapping(value = "/form", method=RequestMethod.GET)
	public String form(Model model) {
		//instantiate an employee object
		Employee employee = new Employee();
		
		//add it to the model
		model.addAttribute("employee", employee);

		//get out
		return "form";
	}

	
	@RequestMapping(value = "/form", method=RequestMethod.POST)
	public String formSubmit(@Valid Employee employee, BindingResult bindingResult, Model model) {
		System.err.println("I got here");
		
        if (bindingResult.hasErrors()) {
            return "form";
        }
		
		return "redirect:/formSuccess";
	}
	
	
	//redirect to demo if user hits the root
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:form";
	}
}
