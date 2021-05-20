package com.invesTacking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.invesTacking.model.User;
import com.invesTacking.model.UserLogin;
import com.invesTacking.service.UserService;

@Controller
public class UserRegController {

	@Autowired
	UserService service;
	
	@RequestMapping("/userReg")
	public String empReg(@ModelAttribute("userObj") User user) {
		
		return "userReg";
	}
	
	@RequestMapping(value="/userRegForm", method = RequestMethod.POST)
	public ModelAndView empForm(@ModelAttribute("userObj") User user,Model model) {
		ModelAndView mv = new ModelAndView();
		
		if(service.registerUser(user)) {
			mv.addObject("userLoginObj", new UserLogin());
			mv.setViewName("index");
			return mv;
		}else {
			mv.addObject("userObj", new User());
			mv.setViewName("userReg");
			return mv;
		}
		
	}
}
