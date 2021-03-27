package com.tl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("accoutmember")
@Entity
@Table(name="accountmember" )
public class AccountMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AccountID")
	private Integer accountID;
	
	@Column(name="Account")
	private String account;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="RealName")
	private String realName;
	
	@Column(name="NickName")
	private String nickName;
	
	@Column(name="PhoneNumber")
	private String phoneNumer;
	
	@Column(name="BirthDay")
	private String birthday;
	
	@Column(name="ProtraitName")
	private String protraitName;
	
	@Column(name="UserProtrait")
	private byte[] userProtrait;
	
	@Column(name="Sex")
	private String sex;
	
	@Column(name="District")
	private String distinct;
	
	@Column(name="YummyPoint")
	private Integer YummyPoint;
	
	@Column(name="Level_ID")
	private String level_id;

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getProtraitName() {
		return protraitName;
	}

	public void setProtraitName(String protraitName) {
		this.protraitName = protraitName;
	}

	public byte[] getUserProtrait() {
		return userProtrait;
	}

	public void setUserProtrait(byte[] userProtrait) {
		this.userProtrait = userProtrait;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDistinct() {
		return distinct;
	}

	public void setDistinct(String distinct) {
		this.distinct = distinct;
	}

	public Integer getYummyPoint() {
		return YummyPoint;
	}

	public void setYummyPoint(Integer yummyPoint) {
		YummyPoint = yummyPoint;
	}

	public String getLevel_id() {
		return level_id;
	}

	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}
	
	
	
}
