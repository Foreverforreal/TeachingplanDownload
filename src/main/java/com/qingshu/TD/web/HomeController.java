package com.qingshu.TD.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingshu.TD.service.TDService;

@Controller
public class HomeController {
	@Autowired
	private TDService tDService;
	
	@RequestMapping("/Home")
	public String goHome(){
		tDService.getReady();
		return "home";
	}
	
	@RequestMapping("/Search")
	public String goSearch(){
		return "home";
	}
	
}
