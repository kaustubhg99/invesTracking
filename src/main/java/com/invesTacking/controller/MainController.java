package com.invesTacking.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.invesTacking.model.User;
import com.invesTacking.model.UserDetails;
import com.invesTacking.model.UserLogin;
import com.invesTacking.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService service;
	
	@RequestMapping("/")
	public String display(@ModelAttribute("userLoginObj") UserLogin login) {
			
			return "index";
	}
	
	@RequestMapping("/sign-out")
	public String display1(@ModelAttribute("userLoginObj") UserLogin login, HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/home")
	public ModelAndView loginController(@ModelAttribute("userLoginObj") UserLogin login, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		if(login.getUserName()!=null && login.getUserPassword()!=null) {
					
					User user = service.checkUserLoginUser(login.getUserName(), login.getUserPassword());
						
					if(user!=null) {
						List<UserDetails> userDetailsList = service.getUserDetailsById(user.getUser_Id());
						setHttpSession(user, session);
						mv.addObject("userDetailsList", userDetailsList);
						mv.addObject("invesObj", new UserDetails());
						mv.setViewName("home");
						return mv;
					}else {
						mv.addObject("msg", "Invalid Credentials!!");
						mv.setViewName("index");
						return mv;
					}
					
				}else {
					mv.addObject("msg", "Invalid Credentials!!");
					mv.setViewName("index");
					return mv;
					
				}
		}
	
	private void setHttpSession(User user, HttpSession session) {
		session.setAttribute("invesUserSession", user.getUser_Id());
		session.setAttribute("invesUserNameSession", user.getUser_FirstName());
	}
}
