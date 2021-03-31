package com.tl.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.tl.util.LoginDemoInterceptor;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.tl"})
public class SpringMvcJavaConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	//定義pages裡面jsp路徑
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(3);
		return viewResolver;
	}
    @Bean
    LoginDemoInterceptor demoInterceptor() {
         return new LoginDemoInterceptor();
    }
 
    
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		 registry.addInterceptor(new LoginDemoInterceptor());
		    registry.addInterceptor(new LoginDemoInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.MainPage/**","/login.controller/**");
		  //registry.addInterceptor(new LoginDemoInterceptor()).addPathPatterns("/secure/*");
	}

	//定義靜態資源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("images/**").addResourceLocations("/WEB-INF/resources/images/");		
	}
	
	//定義json view，讓json印出來好看一點
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setPrettyPrint(true);
		return jsonView;
	}
	
	//註冊要轉乘json的bean()目前是null;setPackagesToScan的功能待研究
	@Bean
	public Jaxb2Marshaller jaxbMarshaller() {
		Jaxb2Marshaller jaxbMarshaller = new Jaxb2Marshaller();
//		jaxbMarshaller.setClassesToBeBound(null);
		jaxbMarshaller.setPackagesToScan("com.tl.model");
		return jaxbMarshaller;
	}
	
	//把預設的view設定為jsonView
	@Bean ContentNegotiatingViewResolver negotiatingViewResolver() {
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		ArrayList<View> views = new ArrayList<>();
		views.add(jsonView());
		viewResolver.setDefaultViews(views);
		return viewResolver;

	}
	
	
	
	
	
	
	
}
