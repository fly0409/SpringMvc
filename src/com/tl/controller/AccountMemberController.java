package com.tl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tl.model.AccountMember;
import com.tl.model.AccoutMemberDao;

@Controller
public class AccountMemberController {
	
	@Autowired @Qualifier("accountMemberDao")
	private AccoutMemberDao accMdao;
	@Autowired
	private AccountMember acc;
	
	@RequestMapping(path="accountMemberAdd")
	public String directToAddMember(Model m) {
		m.addAttribute("accountMember",new AccountMember());
		return("testadd");
	}
	
	@GetMapping(path="accMemUpdateGet")
		public String updateAccountMember(@RequestParam("accMemId") Integer accountid,Model m) {
		AccountMember acc2=new AccountMember();
		try {
			acc2 = accMdao.findById(accountid);
			
			m.addAttribute("accountMember",acc2);
			
		} catch (SQLException e) {e.printStackTrace();}
		
		return "updateAccountMember";
		
	}
	@PostMapping(path="accountMemberUpdater")
	public String updateMember(
			@RequestParam("accountID") Integer accountID,
			@RequestParam("account") String account,@RequestParam("password") String password,@RequestParam("realName") String realName,
			@RequestParam("nickName") String nickName,@RequestParam("phoneNumer") String phoneNumer,@RequestParam("birthday") String birthday,
			@RequestParam("sex") String sex,@RequestParam("distinct") String distinct,@RequestParam("yummyPoint") Integer yummyPoint,
			@RequestParam("userProtrait") MultipartFile file,HttpServletRequest request) {
		AccountMember acc1;		
		try {
			acc1 = accMdao.findById(accountID);

			acc1.setAccount(account);
			acc1.setPassword(password);
			acc1.setRealName(realName);
			acc1.setNickName(nickName);
			acc1.setPhoneNumer(phoneNumer);
			acc1.setBirthday(birthday);
			acc1.setSex(sex);
			acc1.setDistinct(distinct);
			acc1.setYummyPoint(yummyPoint);	
			
			if (file!=null && file.getOriginalFilename().length()!=0) {
				byte[] fileByte = file.getBytes();
				Blob blob = new SerialBlob(fileByte);
				acc1.setUserProtrait(blob);
				
				//檔案儲存在本地端
				
				String fileName = acc1.getProtraitName();
				String saveDirPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF\\resources\\images\\";
				System.out.println("sessionid:"+request.getSession().getId());
				//fileName = "img"+request.getSession().getId()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
				acc1.setProtraitName(fileName);	
				File fileDir = new File(saveDirPath);
				fileDir.mkdirs();
				
				String saveFilePath = saveDirPath + fileName;
				System.out.println("saveFilePath:" + saveFilePath);
				
				//建立儲存路徑(位置+檔名)的filePath
				File saveFile = new File(saveFilePath);
				try {			
					file.transferTo(saveFile);
					System.out.println("file sava to"+saveFilePath);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
				accMdao.addAccountMember(acc1);
			}else {
				accMdao.addAccountMember(acc1);
			}
			
		
			
		} catch (SQLException e2) {	e2.printStackTrace();
		} catch (IOException e) {e.printStackTrace();}				
		return "redirect:/accountMemberAll";
	}
		
	@PostMapping(path="accountMemberAdder")
	public String addMember(
			@RequestParam("account") String account,@RequestParam("password") String password,@RequestParam("realName") String realName,
			@RequestParam("nickName") String nickName,@RequestParam("phoneNumer") String phoneNumer,@RequestParam("birthday") String birthday,
			@RequestParam("sex") String sex,@RequestParam("distinct") String distinct,@RequestParam("yummyPoint") Integer yummyPoint,
			@RequestParam("userProtrait") MultipartFile file,HttpServletRequest request) {
		AccountMember acc1=new AccountMember();
		acc1.setAccount(account);
		acc1.setPassword(password);
		acc1.setRealName(realName);
		acc1.setNickName(nickName);
		acc1.setPhoneNumer(phoneNumer);
		acc1.setBirthday(birthday);
		acc1.setSex(sex);
		acc1.setDistinct(distinct);
		acc1.setYummyPoint(yummyPoint);
		
		
		//for pic insert
		if(file!=null && file.getOriginalFilename().length()!=0) {
			//multipart file to BLOB
			try {
				byte[] fileByte = file.getBytes();
				Blob blob = new SerialBlob(fileByte);
				acc1.setUserProtrait(blob);				
			} catch (Exception e1) {e1.printStackTrace();}	
			
			//檔案儲存在本地端
			String fileName = file.getOriginalFilename();
			String saveDirPath = request.getSession().getServletContext().getRealPath("/") + "WEB-INF\\resources\\images\\";
			System.out.println("sessionid:"+request.getSession().getId());
			fileName = "img"+UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
			acc1.setProtraitName(fileName);	
			File fileDir = new File(saveDirPath);
			fileDir.mkdirs();			
			String saveFilePath = saveDirPath + fileName;
			System.out.println("saveFilePath:" + saveFilePath);			
			//建立儲存路徑(位置+檔名)的filePath
			File saveFile = new File(saveFilePath);
			try {			
				file.transferTo(saveFile);
				System.out.println("file sava to"+saveFilePath);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else {
			acc1.setUserProtrait(null);				
		}
		
		
		
		accMdao.addAccountMember(acc1);

		

		
		return "redirect:/accountMemberAll";
	}
	
	@GetMapping("/delectAccountMember")
	public String deleteAccountMember(@RequestParam("accountId") Integer accMemID) {
		boolean result = accMdao.deleteAccountMember(accMemID);
		if(result) {
			return "redirect:/accountMemberAll";
		}
		return "redirect:/accountMemberAll";
		
	}
	
	
	
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
		Blob  pic = acc.getUserProtrait();
		byte[] picByte =pic.getBytes(1, (int)pic.length());
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(picByte,header,HttpStatus.OK);
		
	}
		

}
