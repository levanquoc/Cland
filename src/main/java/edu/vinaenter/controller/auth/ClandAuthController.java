package edu.vinaenter.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.constants.URLConstant;
@Controller
@RequestMapping(URLConstant.URL_AUTH)
public class ClandAuthController {
 @GetMapping(URLConstant.URL_AUTH_LOGIN)
  public String login() {
	return "admin.login";
}
}
