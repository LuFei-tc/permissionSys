package com.ycsf.persys.modalur.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	//这个方法不实现登录的逻辑，仅处理登录过程中的异常
	@RequestMapping("/login")
	public String login() {
		System.out.println("/login");
		return "/login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/logout";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
}
