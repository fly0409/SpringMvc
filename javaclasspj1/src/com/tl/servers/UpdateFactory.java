package com.tl.servers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tl.bean.FactoryBean;
import com.tl.dao.FactoryDAOimpl;


@WebServlet("/UpdateFactory")
public class UpdateFactory extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int facID=Integer.parseInt(request.getParameter("facID"));
		String facLocation=request.getParameter("facLocation");
		String facCountry=request.getParameter("facCountry");
		String facName=request.getParameter("facName");
		String facAddress=request.getParameter("facAddress");
		String facPhone=request.getParameter("facPhone");
		String facUrl=request.getParameter("facUrl");
				
		FactoryBean fac = new FactoryBean(facID,facLocation,facCountry,facName,facAddress,facPhone,facUrl);
		FactoryDAOimpl facimp=new FactoryDAOimpl();
		facimp.updateFactory(fac);
		request.getRequestDispatcher("ShowFactory").forward(request, response);
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
