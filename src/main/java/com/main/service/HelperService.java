package com.main.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.main.entities.Admin;
import com.main.entities.Constants;
import com.main.entities.Message;

@Service
public class HelperService {

	@Autowired
	TransactionService service;

	public HelperService() {

	}

	public String verifyAdmin(Admin admin, Model model, HttpSession session) {
		if (admin.getUsername().equals(Constants.USERNAME) && admin.getPassword().equals(Constants.PASSWORD)) {

			model.addAttribute("title", "Dashboard");
			service.updateFineContinuously();
			return "Basic/dashboard";
		} else {
			model.addAttribute("title", "Login");
			model.addAttribute("admin", admin);
			session.setAttribute("message", new Message("Wrong Username or Password", "alert-danger"));
			return "Basic/login";
		}
	}

}
