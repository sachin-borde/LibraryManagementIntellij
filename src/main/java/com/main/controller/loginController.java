package com.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.entities.Admin;
import com.main.service.HelperService;

@Controller
@RequestMapping("/app/**")
public class loginController {

	@Autowired
	HelperService helperService;

	public loginController() {
	}

	/*
	 * Handling of Request to Open HOME PAGE
	 */
	@GetMapping("/app/home")
	public String getBookById(Model model, HttpSession session) {

		model.addAttribute("title", "Home");
		return "Basic/home";
	}

	/*
	 * Handling of Request to Open LOGIN PAGE
	 */
	@GetMapping("/app/login")
	public String login(Model model, HttpSession session) {

		model.addAttribute("title", "Login");
		model.addAttribute("admin", new Admin());
		return "Basic/login";
	}

	/*
	 * Handling of LOGOUT Request
	 */
	@PostMapping("/app/logout")
	public String logout(Model model, HttpSession session) throws IOException, ServletException {

		model.addAttribute("title", "Login");
		model.addAttribute("admin", new Admin());
		return "Basic/login";
	}

	/*
	 * Handling of Request to verify Login Credentials
	 */
	@PostMapping("/app/verify")
	public String dashboard(@ModelAttribute("admin") Admin admin, Model model, HttpSession session) {

		return helperService.verifyAdmin(admin, model, session);

	}

	/*
	 * Handling of Request to Open DASHBOARD
	 */
	@GetMapping("/app/dashboard")
	public String backToDashboard(Model model) {

		model.addAttribute("title", "Dashboard");
		return "Basic/dashboard";
	}

}
