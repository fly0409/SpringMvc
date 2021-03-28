package com.tl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	
	@GetMapping("/")
	public String directToMain() {
		return "redirect:/accountMemberAll";
	}
}