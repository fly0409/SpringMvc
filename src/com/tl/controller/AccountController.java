package com.tl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tl.model.Account;
import com.tl.model.AccountDao;

@Controller
@SessionAttributes(names = {"loginUser"})
public class AccountController {

	@RequestMapping("/login.MainPage")
	public String loginMainPage(Model model) {
		 model.addAttribute("account", new Account()); 
		return "accountLogin";
	}
	@Autowired @Qualifier("accountDao")
	private AccountDao accdao;
	
	@RequestMapping("login.controller")	
	public String loginCheck(@ModelAttribute("account") Account account,BindingResult result,Model model) {
		Map<String,String> errors=new HashMap<String,String>();
		model.addAttribute("errors",errors);
		
		if(account.getUsername()==null || account.getUsername().length()==0) {
			errors.put("name", "name is required");
		}
		if(account.getUserpwd()==null || account.getUserpwd().length()==0) {
			errors.put("pwd", "user pwd is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "accountLogin";
		}		
		
		if(result.hasErrors()) {
			return "accountLogin";
		}
		
		boolean checkResult = accdao.checkLogin(account);
		
		if (checkResult) {
			model.addAttribute("loginUser",account.getUsername());
			return "redirect:/accountMemberAll";
		}
		
		errors.put("result", "somthing wrong");
		return "accountLogin";
	}
	
	@GetMapping("logout.controller")
	public String logOut(Model m,HttpSession httpSession, SessionStatus sessionStatus ) {
		if (httpSession.getAttribute("loginUser")!=null) {
			System.out.println(sessionStatus);
			sessionStatus.setComplete();
			System.out.println(sessionStatus);
			return "redirect:/login.MainPage";
		}
		return "redirect:/login.MainPage";
		
	}
	
	
}
