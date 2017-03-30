package com.careydevelopment.ajaxdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxDemoController {

	//starting page for Thymeleaf table demo
	@RequestMapping("/thymeleafTable")
	public String thymeleafTable(Model model) {
		
		//let's create the list we're going to step through in Thymeleaf
		List<String> list = new ArrayList<String>();
		list.add("Item 1");
		list.add("Item 2");
		list.add("Item 3");
		list.add("Item 4");
		list.add("Item 5");
		list.add("Item 6");
		list.add("Item 7");
		list.add("Item 8");
		list.add("Item 9");
		list.add("Item 10");
		list.add("Item 11");
		list.add("Item 12");
		
		//add the list to the model
		model.addAttribute("list", list);
		
		//get out
		return "thymeleafTable";
	}

	
	//redirect to demo if user hits the root
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:thymeleafTable";
	}

}
