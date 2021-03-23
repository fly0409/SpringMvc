package com.tl.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.model.Account;
import com.tl.model.AccountDao;

@Controller
public class HiberTestController {
	
	@Autowired @Qualifier("accountDao")
	private AccountDao accDao;
	
	@RequestMapping(path="/hibertest.controller")
	public String hiberTest(Model m) {
		
		try {
			Account acc = accDao.findById(1);
			m.addAttribute("name",acc.getUsername());
			
			
		} catch (SQLException e) {e.printStackTrace();}
		
		
		return "test";
	}
}
