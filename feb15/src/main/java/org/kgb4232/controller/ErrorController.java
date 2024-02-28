package org.kgb4232.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	
	//	/error
	@GetMapping("/error")
	public String error() {
		return "error/error";
	}
}
