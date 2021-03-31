package com.tl.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.tl"})
public class AppContext {

	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.tl");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		
	}
	@Bean
	public Properties hibernateProperties() {
		Properties settings = new Properties();
		settings.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		settings.put("hibernate.show_sql", "true");
		settings.put("hibernate.format_sql","true");
//		settings.put("hbm2ddl.auto","update");
		
//		settings.put("current_session_context_class","thread");
		return settings;
	}
	@Bean
	public DataSource dataSource() {
	        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
	        DataSource dataSource = dsLookup.getDataSource("java:comp/env/tai/servdb");
	        return dataSource;
	 } 
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		LocalSessionFactoryBean sessoinFac = sessionFactory();
		transactionManager.setSessionFactory(sessoinFac.getObject());
		return transactionManager;
	}	
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(100000);
	    return multipartResolver;
	}
	
}
	
	
	

