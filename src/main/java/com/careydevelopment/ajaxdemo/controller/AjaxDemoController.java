package com.careydevelopment.ajaxdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxDemoController {

	//starting page for AJAX demo
	@RequestMapping("/ajaxDemo")
	public String ajaxDemo(Model model) {		
		//get out
		return "ajaxDemo";
	}

	
	//redirect to demo if user hits the root
	@RequestMapping("/")
	public String home(Model model) {
		return "redirect:ajaxDemo";
	}

}
