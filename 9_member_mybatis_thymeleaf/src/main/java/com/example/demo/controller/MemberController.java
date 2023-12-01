package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Member;
import com.example.demo.service.impl.MemberDaoImpl;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberController {

	@Autowired
	private HttpSession session;
	@Autowired
	private MemberDaoImpl md;
	
	@PostMapping("login")
	public ModelAndView login(
			@RequestParam("username") String username, 
			@RequestParam("password") String password) {
		
		ModelAndView mav = new ModelAndView("index");
		Member user = md.queryUser(username, password);
		
		if(user != null) {
			session.setAttribute("user", user);
			mav.setViewName("loginSuccess");
		}else {
			mav.setViewName("loginError");
		}
		
		return mav;
	}
	
	@GetMapping("addMember")
	public ModelAndView addMember() {
		return new ModelAndView("addMember");
	}
	
	@PostMapping("addMember")
	public ModelAndView addMember(String name, String username, String password, 
			String address, String phone, String mobile) {
		
		ModelAndView mav = new ModelAndView("index");
		
		if(!md.queryUsername(username)) {
			Member m = new Member(name, username, password, address, phone, mobile);
			md.add(m);
			mav.setViewName("addMemberSuccess");
		}else {
			mav.setViewName("addMemberError");
		}
		
		return mav;
	}
}
