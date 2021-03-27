package com.tl.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tl.model.AccountMember;
import com.tl.model.AccoutMemberDao;

@Controller
public class AccountMemberController {
	
	@Autowired @Qualifier("accountMemberDao")
	private AccoutMemberDao accMdao;
	
	@RequestMapping(path="/accountMember.controller")
	public String getAccountMember(Model m) throws SQLException {
		AccountMember acc = accMdao.findById(1001);
		String accName = acc.getAccount();
		m.addAttribute("accName", accName);
		return "account";		
	}
	
	@RequestMapping(path="/accountMemberAll")
	public String getAllAccountMembers(Model m) {
		List<AccountMember> allmem = accMdao.selectAllAccMember();
		m.addAttribute("allmember",allmem);
		return "backstage_mainPage";
	}
	
	@RequestMapping(path="/accountMember.pic",method = RequestMethod.GET,produces = "image/jpeg")
	@ResponseBody
	public ResponseEntity<byte[]> processResponseByteArray(@RequestParam("accountId") int accountId) throws IOException, SQLException {
		AccountMember acc = accMdao.findById(accountId);
		byte[] pic = acc.getUserProtrait();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(pic,header,HttpStatus.OK);
		
	}
	
	

}
