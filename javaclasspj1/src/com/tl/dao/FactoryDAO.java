package com.tl.dao;

import java.util.List;

import com.tl.bean.FactoryBean;

public interface FactoryDAO {
	public List<FactoryBean> getAllFactory();  	  

	public FactoryBean getFactory(int FacID);  	  

	public void updateFactory(FactoryBean factory);  
	
	public void addFactory(FactoryBean factory);	  

	public void deleteFactory(int FacID);  
}
