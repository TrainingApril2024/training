package com.apex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apex.beans.Student;
import com.apex.beans.User;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		modelAndView.addObject("message", "Welcome to Spring MVC Project. Hi");
		return modelAndView;
	}

	@RequestMapping(value = "/displayObject", method = RequestMethod.GET)
	public ModelAndView getObject() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("showObject");
		User user = new User();
		user.setName("Ram");
		user.setAge(35);
		user.setCity("Fremont");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value = "/showQueryParameter", method = RequestMethod.GET)
	public ModelAndView getQueryParameter(@RequestParam(value ="id", required = false, defaultValue = "12") int id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		modelAndView.addObject("message", "Welcome to Spring MVC Project. Hi");
		modelAndView.addObject("id", id);
		return modelAndView;
	}
	
	@RequestMapping(value = "/studentForm", method = RequestMethod.GET)
	public String studentForm(ModelMap modelMap) {
		modelMap.addAttribute("message", "This is Student Form");
		return "form";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute Student student) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayStudent");
		modelAndView.addObject("student",student);
		return modelAndView;
	}
}
