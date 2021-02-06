package com.tl.servers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.bean.FactoryBean;
import com.tl.dao.FactoryDAOimpl;

@WebServlet("/ShowFactory")
public class ShowFactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FactoryDAOimpl facimp=new FactoryDAOimpl();
		List<FactoryBean> faclist = facimp.getAllFactory();
		request.setAttribute("faclist", faclist);
		request.getRequestDispatcher("/html/showFactory.jsp").forward(request, response);		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
