package edu.vinaenter.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("admin/index")
	public String index() {
		return "admin.index";
	}
	@GetMapping("admin/cat")
	public String cat() {
		return "admin.cat";
	}
	@GetMapping("admin/add")
	public String add() {
		return "admin.add";
	}
	@GetMapping("admin/news")
	public String news() {
		return "admin.news";
	}
	@GetMapping("admin/login")
	public String login() {
		return "admin.login";
	}
	
}
