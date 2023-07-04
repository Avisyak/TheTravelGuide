package com.Phoenix.ProjectWork.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/")
	public String getHome() {
		return "Home";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "UserLogin";
	}

}
